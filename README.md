# Spring-Learning

# setup kafka and zookeeper and kafdrop ui
docker-compose up -d

docker exec -it kafka bash

kafka-topics \
--bootstrap-server localhost:9092 \
--create \
--topic online-payments \
--partitions 6 \
--replication-factor 1

