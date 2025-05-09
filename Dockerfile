# Stage 1: Build the application
FROM openjdk:21-slim
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

# TODO: REMOVE THIS SHIT
RUN ls -lah
RUN ls -lah /
RUN ls -lah /app/
RUN ls -lah /app/pgi/
RUN ls -lah /app/pgi/build/
RUN ls -lah /app/pgi/build/libs/

# Expose the application port
EXPOSE 8080

# Set the entry point for the application
ENTRYPOINT ["java", "-jar", "app.jar"]
