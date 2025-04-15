# Build image on docker hub
#FROM eclipse-temurin:21-jdk-jammy
FROM openjdk:21-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]