import argparse 
import atexit
import json
import logging
import requests
import schedule
import time
import sys, os

from kafka import KafkaProducer 
from kafka.errors import KafkaError, KafkaTimeoutError 

# Default kafka topic write to
topic_name = 'analyzer'

# Default kafka broker location, topic_name
kafka_broker = '192.168.254.42:9092'

API_BASE = 'https://api.gdax.com'

logger_format = '%(asctime)-15s %(message)s'
logging.basicConfig(format = logger_format)
logger = logging.getLogger('data-producer')
logger.setLevel(logging.DEBUG)

def fetch_price(symbol, producer, topic_name):
    """
    helper function to retrieve asset data and send it to kafka
    :param symbol: the symbol of asset
    :param producer: instance of a kafka producer
    :return: None
    """
    logger.debug('Start to fetch price for %s' % symbol)
    try:
        response = requests.get('%s/products/%s/ticker' % (API_BASE, symbol))

        price = response.json()['price']

        timestamp = time.time()
        payload = {
            'Symbol': str(symbol),
            'LastTradePrice': str(price),
            'LastTradeDateTime': str(timestamp)
        }

        logger.debug('Retrieved %s info %s', symbol, payload)

        # there are trwo things required to return it into bytes -- serialize it to a string via JSON
        # and then encode that bytes as UTF-8
        producer.send(topic = topic_name, value = json.dumps(payload).encode('utf-8'), timestamp_ms = int(time.time() * 1000))

        logger.debug('Sent price for %s to Kafka' % symbol)
    except KafkaTimeoutError as timeout_error:
        logger.warn('Failed to send price to kafka, casued by: %s', timeout_error)
    except Exception as e:
        logger.warn('Failed to fetch price: %s', e) 
        exception_type, exception_obj, exception_tb = sys.exc_info()
        fname = os.path.split(exception_tb.tb_frame.f_code.co_filename)[1]
        print(exception_type, fname, exception_tb.tb_lineno)

def shutdown_hook(producer):
    """
    a shutdown hook to be called before the shutdown
    :param producer: instance of a kafka producer
    :return None
    """
    try:
        logger.info('Flushing pending messages to kafka, timeout is set to 10s')
        producer.flush(10)
        logger.info('Finish flushjing pending messages to kafka')
    except KafkaError as kafka_error:
        logger.warn('Failed to flush pending message to kafka, caused by: %s', kafka_error.invalid_metadata)
    finally:
        try:
            logger.info('Closing kafka connection')
            producer.close(10)
        except Exception as e:
            logger.warn('Failed to close kafka connection, caused by: connection issue')

def check_symbol(symbol):
    """
    helper method to check if the symbol exists in coinbase API
    """
    logger.debug('Checking symbol.')        
    try:
        response = requests.get(API_BASE + '/products')
        product_ids = [product['id'] for product in response.json()]
        if symbol not in product_ids:
            logger.warn('Symbol %s not supported. The list of supported symbols: %s', symbol, product_ids)
            exit()
    except Exception as e:
        logger.warn('Failed to fetch products: %s', e)

if __name__ == '__main__':
    # Setup command line arguments
    parser = argparse.ArgumentParser()
    parser.add_argument('symbol', help = 'the symbol you want to pull')    
    parser.add_argument('topic_name', help = 'the kafka topic push to')
    parser.add_argument('kafka_broker', help = 'the location of the kafka broker')

    # Parse arguments    
    args = parser.parse_args()
    symbol = args.symbol
    topic_name = args.topic_name
    kafka_broker = args.kafka_broker

    # Check if the symbol is supported.
    check_symbol(symbol)

    # Instantiate a simple kafka producer
    producer = KafkaProducer (
        bootstrap_servers = kafka_broker
    )

    # Schedule and run the fetch_price function every second
    schedule.every(1).second.do(fetch_price, symbol, producer, topic_name)

    # Setup proper shudown hook
    atexit.register(shutdown_hook, producer)

    while True:
        schedule.run_pending()
        time.sleep(1)