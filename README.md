# Docker
```
docker run -d --name cassandra-container -e CASSANDRA_USERNAME=ndtrong -e CASSANDRA_PASSWORD=ndtrong -p 9042:9042 cassandra:3.11.16
```
# Kafka
https://github.com/provectus/kafka-ui
```
docker run -it -p 8080:8080 -e DYNAMIC_CONFIG_ENABLED=true provectuslabs/kafka-ui
```