FROM openjdk:17-alpine
ARG JAR_FILE=/build/libs/with-slack.jar
COPY ${JAR_FILE} with-slack.jar
ENTRYPOINT ["java","-jar","with-slack.jar"]