# kafka_demo

topic name  :  mytopic
``` run
/kafka-topics.sh --create --topic mytopic --bootstrap-server localhost:9092 --replication-factor 1 --partitions 4
```
```  write message to topic 
bin/kafka-console-producer.sh --topic mytopic --bootstrap-server localhost:9092
```

``` 
bin/kafka-console-consumer.sh --topic mytopic --from-beginning --bootstrap-server localhost:9092
```
