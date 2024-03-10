# Docker
```
docker run -d --name cassandra-container -e CASSANDRA_USERNAME=ndtrong -e CASSANDRA_PASSWORD=ndtrong -p 9042:9042 cassandra:3.11.16
```
# Kafka
https://github.com/provectus/kafka-ui
```
docker run -it -p 8080:8080 -e DYNAMIC_CONFIG_ENABLED=true provectuslabs/kafka-ui
```

# Elastic search
```
version: "3.0"
services:
  elasticsearch:
    container_name: es-container
    image: docker.elastic.co/elasticsearch/elasticsearch:7.17.0
    environment:
      - xpack.security.enabled=false
      - "discovery.type=single-node"
    networks:
      - es-net
    ports:
      - 9200:9200
  kibana:
    container_name: kb-container
    image: docker.elastic.co/kibana/kibana:7.17.0
    environment:
      - ELASTICSEARCH_HOSTS=http://es-container:9200
    networks:
      - es-net
    depends_on:
      - elasticsearch
    ports:
      - 5601:5601
networks:
  es-net:
    driver: bridge
```