FROM openjdk:17
EXPOSE 8080
LABEL authors="christopherharper"
ADD build/libs/queue-consumer.jar queue-consumer.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=production", "/queue-consumer.jar"]