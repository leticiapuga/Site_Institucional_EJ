FROM eclipse-temurin:21-jdk-jammy AS build

WORKDIR /app

RUN apt-get update && apt-get install -y maven

COPY back/pom.xml .

RUN mvn dependency:go-offline

COPY back/src ./src

RUN mvn clean package -DskipTests


FROM eclipse-temurin:21-jre-jammy

RUN apt-get install -y curl

WORKDIR /app

RUN apt-get install -y curl

COPY --from=build /app/target/landingpage-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]