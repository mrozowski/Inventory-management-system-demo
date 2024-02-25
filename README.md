# Inventory menagment system - demo

This project uses event-driven architecture and simulates real-time updates to inventory. 
It employs Kafka to send events signaling inventory changes, such as items being sold or added to stock. Additionally, it triggers alert events when the quantity is critically low or empty.

## Technologies used:
* Java 17
* Kotlin
* Spring boot 3.2
* Kafka
* Postgres
* ElasticSearch
* Kibana
* Logstash
* Docker

## Project diagram
![Kafka](https://github.com/mrozowski/Inventory-management-system-demo/assets/67066372/b0b045b9-73cf-4268-9f7f-6286c8282dd6)

**Test Event Generator Service** - Simple service for generating Kafka Events such as item sold or item added event. More about service here [readme.md](/TestEventProducer/readme.md)

**Inventory Service** - Main service, it consumes Kafka events and updates a database. It also publishes events with the current item quantity and alerts when the quantity is low or empty.
 

## How to run
Make sure you have Java 17, Docker and Docker-Compose on your machine.
* Run `docker-compose up -d`
* Run both services. For this, you can use your IDE
* Fill a database with some test data - _example sql script below_
* Make a call to `curl localhost:8085/v1/produce/sold?id=1&amount=1`
* Open Kibana - http://localhost:5601/   - _On the first run you might need to create data view in Kibana to see logs_


Example sql script
``` sql
INSERT INTO items (internal_id, name, description, quantity, price)
VALUES ('SKU001', 'Notebook', 'Plain notebook with lined paper', 200, 299),
       ('SKU002', 'Pen', 'Blue ballpoint pen', 500, 99),
       ('SKU003', 'Calculator', 'Basic calculator with solar power', 100, 499),
       ('SKU004', 'Sticky Notes', 'Pack of colorful sticky notes', 300, 199),
       ('SKU005', 'Highlighter', 'Yellow highlighter pen', 400, 79);
```

## Main service diagram
![Kafka (1)](https://github.com/mrozowski/Inventory-management-system-demo/assets/67066372/ca54835a-6ac5-4c13-9895-388324fcd01b)

**Why kotlin for Spring Boot**
I decided to use Kotlin for Spring Boot app out of curiosity. I wanted to know if Kotlin is a good choice for backend. The language semantics is fine and already worked with Kotlin in Android. 
I can say I could work with Spring boot + Kotlin but there are differences that require a different approach than in Java. 

- The first thing is Lombok. In Java, it is a very useful library that saves time writing boilerplate code. However, In Kotlin Lombok does not work. That being said Lombok might not be as useful in Kotlin as this language provides its own ways to reduce boilerplate code but still @Builder or @Getter would be good in some situations.
- Kotlin has better null handling which makes code more robust. But it might require some time to learn how to use it properly.
- Kotlin also provides built-in support for coroutines, which might simplify asynchronous programming. 

## ELK

The project also implements the ELK stack to collect and search logs from both services. Each service saves logs in a file inside `/logs/` directory. 
Logstash reads logs from these files and passes them to elasticsearch which later can be accessed by Kibana.

### Kibana logs
![image](https://github.com/mrozowski/Inventory-management-system-demo/assets/67066372/fa94e5c5-662a-4d3f-aec1-5909532caf3c)
