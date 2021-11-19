FROM openjdk:8-jdk-alpine
LABEL maintainer = "Somnath Musib"
VOLUME /catalog-service
ADD target/catalog-service-0.0.1-SNAPSHOT.jar catalog-service.jar
EXPOSE 7001
ENTRYPOINT ["java", "-jar", "catalog-service.jar"]