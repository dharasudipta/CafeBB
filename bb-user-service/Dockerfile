FROM eclipse-temurin:19-jdk-alpine
VOLUME /tmp
COPY target/*.jar bb-user-service.jar
ENTRYPOINT ["java","-jar","/bb-user-service.jar"]