# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/kmsoftService.jar app.jar
EXPOSE 8080 # Or whatever port your Spring Boot app listens on
ENTRYPOINT ["java", "-jar", "app.jar"]