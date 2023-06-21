FROM openjdk:17-jdk-slim

VOLUME /tmp
WORKDIR /app

ARG JAR_FILE
COPY ${JAR_FILE} app.jar

ARG CREDENTIALS
COPY ${CREDENTIALS} credentials.json
ENV GOOGLE_APPLICATION_CREDENTIALS=/app/credentials.json

EXPOSE 8080

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]