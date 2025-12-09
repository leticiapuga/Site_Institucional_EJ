FROM maven:3.9-eclipse-temurin-21-alpine AS build

WORKDIR /app

COPY back/pom.xml .

RUN mvn dependency:go-offline

COPY back/src ./src

RUN mvn clean package -DskipTests


FROM eclipse-temurin:21-jre-alpine

WORKDIR /app


COPY --from=build /app/target/landingpage-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]