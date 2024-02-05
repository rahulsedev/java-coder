# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy

LABEL mentainer="Rahul Dhiman"

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]

EXPOSE 8080
