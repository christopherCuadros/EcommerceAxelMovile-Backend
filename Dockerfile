# FROM maven:3.9.6-eclipse-temurin-17

# COPY src /app/src
# COPY pom.xml /app/

# WORKDIR /app

# RUN mvn clean install
# CMD ["java", "-Dfile.encoding=utf-8", "-jar", "target/TiendaVirtual-0.0.1-SNAPSHOT.jar"]
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT [ "java","-jar","/app.jar" ]
EXPOSE 8080
