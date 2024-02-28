# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn package -DskipTests

# Stage 2: Create the final Docker image
FROM alpine:3.15
WORKDIR /app
COPY --from=build /app/target/kafka-demo.jar /app/kafka-demo.jar
RUN apk add --no-cache openjdk17
CMD ["java", "-jar", "kafka-demo.jar"]