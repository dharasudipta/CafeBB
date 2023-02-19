FROM eclipse-temurin:19-jdk-alpine
VOLUME /tmp
COPY target/*.jar bb-fe-service.jar
COPY target/node node
ENTRYPOINT ["java","-jar","/bb-fe-service.jar"]