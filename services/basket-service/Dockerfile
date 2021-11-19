FROM openjdk:8-jdk-alpine
LABEL maintainer = "Somnath Musib"
VOLUME /basket-service
ADD target/basket-service-0.0.1.jar basket-service.jar
EXPOSE 7001
ENTRYPOINT ["java", "-jar", "basket-service.jar"]