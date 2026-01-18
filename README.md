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

# point java_home to correct java lib

export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH

# Send payments events -

POST http://localhost:8080/payments

# Body

{
  "paymentId": "pay-1001",
  "userId": "user-1",
  "amount": 500,
  "currency": "INR",
  "status": "CREATED"
}
