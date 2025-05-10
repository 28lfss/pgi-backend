# Stage 1: Build the application
FROM openjdk:21-slim
WORKDIR /app/pgi

# Copy application source files
COPY pgi /app/pgi

# Grant execute permissions to gradlew
RUN chmod +x /app/pgi/gradlew

# Run the Gradle build
RUN /app/pgi/gradlew clean build --no-daemon

# Expose the application port
EXPOSE 8080

# Set the entry point for the application
ENTRYPOINT ["java", "-jar", "/app/pgi/build/libs/pgi-0.0.1-SNAPSHOT.jar"]
