#!/bin/sh

echo "Feeding the topic"
docker exec -i kafka kafka-console-producer.sh --bootstrap-server kafka:9092 --topic k8s-resources < messages