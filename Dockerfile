FROM openjdk:17-slim-buster

ADD build/libs/gateway-0.0.1-SNAPSHOT.jar boot.jar

EXPOSE 8000

CMD ["java", "-jar", "boot.jar"]