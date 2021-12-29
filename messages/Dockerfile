FROM openjdk:11

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app/

COPY target/messages-0.0.1-SNAPSHOT.jar /usr/src/app/messages.jar

EXPOSE 8081

CMD ["/bin/sh", "-c", "java -jar messages.jar"]