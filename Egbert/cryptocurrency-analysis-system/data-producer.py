import argparse 
import atexit
import json
import logging
import requests
import schedule
import time

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
    logger.debug('Start to fetch price for %s'% symbol)
    try:
        response = requests.get('%s/products/%s/ticker' % (API_BASE, symbol))

        price = response.json()['price']
        timestamp = time.time()
        payload = {'Symbol':str(symbol)}

