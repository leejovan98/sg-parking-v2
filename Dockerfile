FROM maven:3.8.6-jdk-8
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package

FROM openjdk:8
ADD /target/sg-parking-v2-0.0.1-SNAPSHOT.jar /app/sg-parking-v2-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/sg-parking-v2-0.0.1-SNAPSHOT.jar"]