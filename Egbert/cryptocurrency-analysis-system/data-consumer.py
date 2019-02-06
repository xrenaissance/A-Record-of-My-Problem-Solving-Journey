import argparse
from kafka import KafkaConsumer

# Default kafka topic write to
topic_name = 'analyzer'

# Default kafka broker location
kafka_broker = '192.168.254.42:9092'

def consume(topic_name, kafka_broker):
  consumer = KafkaConsumer(topic_name, bootstrap_servers = kafka_broker)

  for message in consumer:
    # message value and key are raw bytes -- decode if necessary!
    # e.g, for unicode: `message.value.decode('utf-8')`
    print(message)

if __name__ == '__main__':
  parser = argparse.ArgumentParser()
  parser.add_argument('topic_name', help = 'the kafka topic push to')
  parser.add_argument('kafka_broker', help = 'the location of the kafka')

  # Parse arguments
  args = parser.parse_args()
  topic_name = args.topic_name
  kafka_broker = args.kafka_broker

  consume(topic_name, kafka_broker)
