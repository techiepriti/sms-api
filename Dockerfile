FROM maven:latest AS build

ARG MONGO_URI
ENV MONGO_URI=$MONGO_URI

COPY src /usr/src/app/src

COPY pom.xml /usr/src/app

RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:17

COPY --from=build /usr/src/app/target/sms-backend-api-0.0.1-SNAPSHOT.jar /usr/app/sms-backend-api-0.0.1-SNAPSHOT.jar

EXPOSE 6000

CMD ["java", "-jar", "/usr/app/sms-backend-api-0.0.1-SNAPSHOT.jar"]