# Consumer String Serializer

A Spring Boot application for consuming Kafka messages with string serialization.

## Project Description

This project demonstrates how to use Spring Boot and Spring Kafka to consume messages from Kafka topics. It includes custom annotations to reduce boilerplate code and handles multiple consumer groups and partitions.

## Features

- Kafka consumer with custom annotations.
- Multiple consumer groups and topic partitions.
- Exception handling for message processing.
- Dockerized application for easy deployment.

## Prerequisites

- Java 21
- Apache Kafka
- Docker (optional for containerized deployment)

## Installation

# Consumer String Serializer

A Spring Boot application for consuming Kafka messages with string serialization.

## Project Description

This project demonstrates how to use Spring Boot and Spring Kafka to consume messages from Kafka topics. It includes custom annotations to reduce boilerplate code and handles multiple consumer groups and partitions.

## Features

- Kafka consumer with custom annotations.
- Multiple consumer groups and topic partitions.
- Exception handling for message processing.
- Dockerized application for easy deployment.

## Prerequisites

- Java 21
- Apache Kafka
- Docker (optional for containerized deployment)

## Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd consumer-string-serializer
   ```
   
1. Build the project:
   ```bash
    mvn clean install
   ```

1. Run the application:
   ```bash
    mvn spring-boot:run
   ```

3. Access the application at:
- REST API: http://localhost:8000/producer

4. Access Kafdrop to monitor Kafka:
   - URL: [http://localhost:19000](http://localhost:19000)

### Configuration

The application is configured in the `application.yml` file:
```yaml
server:
   port: 8100
   
spring:
  application:
    name: consumer-string-serializer
  kafka:
    consumer:
      bootstrap-servers: localhost:29092
```

### Docker

To build and run the Docker container:
1. Build the Docker image:
   ```bash
   docker build -t rui-soares/consumer-string-serializer:1.0.0 .
   ```

1. Run the container:
   ```bash
    docker run -p 8100:8100 consumer-string-serializer
   ```

## Reference Documentation
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Kafka Documentation](https://spring.io/projects/spring-kafka)
- [Maven Documentation](https://maven.apache.org/guides/index.html)
- [Docker Documentation](https://docs.docker.com/)
- [Lombok Documentation](https://projectlombok.org/)