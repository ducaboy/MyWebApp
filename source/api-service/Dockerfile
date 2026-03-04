# Use lightweight Java image
FROM eclipse-temurin:25

# Set working directory
WORKDIR /app

# Copy jar file into container
COPY target/api-service-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]