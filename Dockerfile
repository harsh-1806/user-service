FROM amazoncorretto:17

WORKDIR /app

COPY target/userService-0.0.1-SNAPSHOT.jar /app/userService-0.0.1-SNAPSHOT.jar

EXPOSE 9810

ENTRYPOINT ["java", "-jar", "/app/userService-0.0.1-SNAPSHOT.jar"]