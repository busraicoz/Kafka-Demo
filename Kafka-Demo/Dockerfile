FROM openjdk:8-jdk-alpine

LABEL maintainer="icozbsr@gmail.com"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/kafka-demo-0.0.1.jar

ADD ${JAR_FILE} kafka-demo-0.0.1.jar

ENTRYPOINT ["java","-jar","target/kafka-demo-0.0.1.jar"]