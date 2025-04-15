# Consumer JSON Serializer

## Description
A Spring Boot application for consuming JSON messages from Kafka and processing them.

## Features
- Kafka consumer integration
- JSON message deserialization
- RESTful web service
- Configurable via `application.yml`

## Prerequisites
- Java 21
- Maven 3.8+
- Docker (optional, for containerization)
- Kafka broker running on `localhost:29092`

## Getting Started

### Build and Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/consumer-json-serializer.git
   cd consumer-json-serializer

2. Build the project:
   ```bash 
   mvn clean install
    ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

3. Access the application at:
- REST API: http://localhost:8001/user

4. Access Kafdrop to monitor Kafka:
   - URL: [http://localhost:19000](http://localhost:19000)
   
### Docker Deployment

1. Build the Docker image:
   ```bash
   docker build -t rui-soares/consumer-json-serializer:1.0.0 .
   ```

1. Run the container:
   ```bash
    docker run -p 8002:8002 rui-soares/consumer-json-serializer:1.0.0
   ```

### Configuration

The application is configured in the `application.yml` file:
```yaml
server:
   port: 8002

spring:
   application:
      name: consumer-json-serializer
   kafka:
      consumer:
         bootstrap-servers: localhost:29092
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