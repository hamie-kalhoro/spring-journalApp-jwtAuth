FROM maven:3.9.6-openjdk-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
COPY --from=build /target/journalApp-0.0.1-SNAPSHOT.jar journalApp.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "journalApp.jar"]