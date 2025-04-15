# Producer String Serializer

## Description

This project is a Spring Boot application that demonstrates a Kafka producer with string serialization. It is configured to send messages to a Kafka topic using the \`spring-kafka\` library.

## Features

- Kafka producer setup with Spring Boot
- String serialization for Kafka messages
- Docker Compose for running Kafka and Kafdrop

## Prerequisites

- Java 21
- Maven
- Docker and Docker Compose

## Getting Started

### Running the Application

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```

2. Start the Kafka environment using Docker Compose:
   ```bash
   docker-compose up
   ```
3. Build the Docker image:
   ```bash
   docker build -t rui-soares/producer-string-serializer:1.0.0 .   

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

5. Access the application at:
- REST API: http://localhost:8000/producer

6. Access Kafdrop to monitor Kafka:
    - URL: [http://localhost:19000](http://localhost:19000)

### Configuration

The application is configured in the `application.yml` file:
```yaml
server:
  port: 8000

spring:
  application:
    name: producer-string-serializer
  kafka:
    producer:
      bootstrap-servers: localhost:29092
```

## Dependencies

- Spring Boot 3.4.4
- Spring Kafka
- Lombok
- Spring Boot Starter Web
- Spring Boot Starter Test

## Reference Documentation
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Kafka Documentation](https://spring.io/projects/spring-kafka)
- [Spring for Apache Kafka](https://docs.spring.io/spring-boot/3.4.4/reference/messaging/kafka.html)
- [Spring Boot Maven Plugin](https://docs.spring.io/spring-boot/3.4.4/maven-plugin)
- [Maven Documentation](https://maven.apache.org/guides/index.html)
- [Docker Documentation](https://docs.docker.com/)
- [Lombok Documentation](https://projectlombok.org/)