# Kafka-Spring-Demo

## Overview

This repository contains a simple Spring Boot application that demonstrates how to use Apache Kafka for messaging. The application showcases basic Kafka operations such as producing and consuming messages within a Spring Boot application framework.

## Prerequisites

Before you run this application, you need to have the following installed:

- Java JDK 11 or later
- Apache Maven 3.6 or later
- Apache Kafka 2.7 or later
- Zookeeper (usually bundled with Kafka)

## Setting Up Apache Kafka

To run this application, you need a running Kafka server. Follow these steps to set up Apache Kafka:

1. Download Apache Kafka from the official [Apache Kafka website](https://kafka.apache.org/downloads).
2. Extract the downloaded tar file to your preferred directory.
3. Start Zookeeper: cd C:\Kafka\kafka_2.13-3.7.0 and run the following command:
   ```bash
   .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
   ```
4. Start Kafka: cd C:\Kafka\kafka_2.13-3.7.0 and run the following command:
   ```bash
   .\bin\windows\kafka-server-start.bat "C:\Kafka\kafka_2.13-3.7.0\config\server.properties"
   ```
5. Create a topic named `test`:
   ```bash
    .\bin\windows\kafka-topics.bat --create --topic test --bootstrap-server localhost:9092
    ```
6. Verify that the topic has been created:
7. ```bash
    .\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
    ```
8. Start Spring Boot application: KafkaSpringApplication.java