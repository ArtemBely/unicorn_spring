FROM openjdk:21
ARG JAR_FILE=build/libs/unicorn-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]