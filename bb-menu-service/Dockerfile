FROM eclipse-temurin:19-jdk-alpine
VOLUME /tmp
COPY target/*.jar bb-menu-service.jar
ENTRYPOINT ["java","-jar","/bb-menu-service.jar"]