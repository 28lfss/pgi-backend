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
RUN ./gradlew clean build --no-daemon || (echo "Gradle build failed" && exit 1)

# Verify if JAR file exists
RUN ls -lah /app/pgi/build/libs/ || (echo "JAR file not found" && exit 1)

# Stage 2: Run the application
FROM openjdk:21-slim
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/pgi/build/libs/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Set the entry point for the application
ENTRYPOINT ["java", "-jar", "app.jar"]
