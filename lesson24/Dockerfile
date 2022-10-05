FROM maven:3.8.6-jdk-11 AS builder

COPY pom.xml pom.xml
RUN mvn package

COPY ./src src/
RUN mvn package

FROM tomcat:9.0.53-jdk11-openjdk
ARG ANY=Andrey
ARG HELLO_ARG=Andrey
ENV HELLO=${HELLO_ARG}
COPY --from=builder target/servlet-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/servlet.war
