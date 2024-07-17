# Use a multi-stage build to keep the final image clean and minimal
# Stage 1: Build the application
FROM gradle:7.5.1-jdk8 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the source code into the container
COPY . .

# Build the application
RUN ./gradlew build -x test

# Stage 2: Create the final image
FROM gcr.io/distroless/java:8

# Set the working directory inside the container
WORKDIR /opt/app

# Copy the jar file from the build stage
COPY --from=build /app/build/libs/customer-service-0.0.1-SNAPSHOT.jar .

# Expose the application port
EXPOSE 8074

# Use a non-root user to run the application
USER nonroot

# Run the application
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","customer-service-0.0.1-SNAPSHOT.jar"]


























#FROM openjdk:8-jdk-alpine

#RUN mkdir -p /opt/build 
#ADD ./ /opt/build
#WORKDIR /opt/build

#RUN chmod +x gradlew


#RUN ./gradlew build -x test \
    # && cp ./build/libs/customer-service-0.0.1-SNAPSHOT.jar customer-service-0.0.1-SNAPSHOT.jar

#EXPOSE 8074
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./customer-service-0.0.1-SNAPSHOT.jar"]
