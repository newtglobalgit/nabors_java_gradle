# Use a minimal base image
FROM gcr.io/distroless/java:8

# Set the working directory inside the container
WORKDIR /opt/app

# Copy the pre-built JAR file into the container
COPY ./build/libs/customer-service-0.0.1-SNAPSHOT.jar .

# Expose the application port
EXPOSE 8074

# Use a non-root user to run the application
USER nonroot

# Run the application
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","customer-service-0.0.1-SNAPSHOT.jar"]
