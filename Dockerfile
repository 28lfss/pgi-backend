# Stage 1: Build the application
FROM openjdk:21-slim AS build
WORKDIR /app

# Copy Gradle wrapper and configuration files
COPY gradlew gradlew.bat settings.gradle build.gradle ./
COPY gradle ./gradle

# Copy application source files
COPY pgi /app/pgi

# Run the Gradle build
RUN ./gradlew clean build --no-daemon

# Stage 2: Run the application
FROM openjdk:21-slim
WORKDIR /app
COPY --from=build /app/pgi/build/libs/pgi-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
