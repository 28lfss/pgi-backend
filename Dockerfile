# Stage 1: Build the application
FROM openjdk:21-slim AS build
WORKDIR /app

# Copy Gradle wrapper and configuration files
COPY pgi/gradlew pgi/gradlew.bat pgi/settings.gradle pgi/build.gradle ./
COPY pgi/gradle ./gradle

# Copy application source files
COPY pgi /app/pgi

# Grant execute permissions to gradlew
RUN chmod +x gradlew

# Run the Gradle build
RUN ./gradlew clean build --no-daemon

# Stage 2: Run the application
FROM openjdk:21-slim
WORKDIR /app
COPY --from=build ./app/pgi/build/libs/pgi-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
