# Docker
```
docker run -d --name cassandra-container -e CASSANDRA_USERNAME=ndtrong -e CASSANDRA_PASSWORD=ndtrong -p 9042:9042 cassandra:3.11.16
```
# Kafka
https://github.com/provectus/kafka-ui
```
docker run --rm -it --name kafka-ui -p 9090:8080 -e KAFKA_CLUSTERS_0_NAME=localhost -e KAFKA_CLUSTERS_0_BOOTSTRAPSERVERS=localhost:9092 -e KAFKA_CLUSTERS_0_ZOOKEEPER=localhost:2181 -e KAFKA_BROKERCONNECT=localhost:9092 -e DYNAMIC_CONFIG_ENABLED=true provectuslabs/kafka-ui
```

<!-- custom -->

docker run --rm -it --name kafka-ui -p 9090:8080 -e KAFKA_CLUSTERS_0_NAME=localhost -e KAFKA_CLUSTERS_0_BOOTSTRAPSERVERS=localhost:9092 -e KAFKA_CLUSTERS_0_ZOOKEEPER=localhost:2181 -e KAFKA_BROKERCONNECT=localhost:9092 provectuslabs/kafka-ui


<!-- draft -->
docker run --rm -it --name kafka-ui -p 9090:8080 -e KAFKA_CLUSTERS_0_NAME=192.168.1.14 -e KAFKA_CLUSTERS_0_BOOTSTRAPSERVERS=192.168.1.14:9092 -e KAFKA_CLUSTERS_0_ZOOKEEPER=192.168.1.14:2181 -e KAFKA_BROKERCONNECT=192.168.1.14:9092 provectuslabs/kafka-ui
