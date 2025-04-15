# Producer JSON Serializer

## Description
`producer-json-serializer` is a Spring Boot application designed to produce JSON messages to a Kafka topic. It uses the `spring-kafka` library for Kafka integration and is built with Java 21 and Maven.

## Features
- Kafka producer configuration for JSON serialization.
- Spring Boot framework for rapid development.
- Dockerized for easy deployment.

## Prerequisites
- Java 21
- Maven 3.8+
- Docker (optional, for containerized deployment)
- Kafka broker running on `localhost:29092`

## Getting Started

### Build and Run Locally
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd producer-json-serializer

1. Build the project:
   ```bash
    mvn clean install
   ```

1. Run the application:
   ```bash
    mvn spring-boot:run
   ```

1. Access the application at:
- REST API: http://localhost:8001/user

5. Access Kafdrop to monitor Kafka:
   - URL: [http://localhost:19000](http://localhost:19000)

### Configuration

The application is configured in the `application.yml` file:
```yaml
server:
  port: 8001

spring:
  application:
    name: producer-json-serializer
  kafka:
    producer:
      bootstrap-servers: localhost:29092
```

### Docker Deployment

1. Build the Docker image:
   ```bash
   docker build -t rui-soares/producer-json-serializer:1.0.0 .
   ```

1. Run the container:
   ```bash
    docker run -p rui-soares/producer-json-serializer:1.0.0
   ```

## Dependencies
- Spring Boot 3.4.4
- Spring Kafka
- Lombok
- Maven

## Reference Documentation
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Kafka Documentation](https://spring.io/projects/spring-kafka)
- [Maven Documentation](https://maven.apache.org/guides/index.html)
- [Docker Documentation](https://docs.docker.com/)
- [Lombok Documentation](https://projectlombok.org/)