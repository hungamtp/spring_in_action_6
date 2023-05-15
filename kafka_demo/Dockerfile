FROM adoptopenjdk/openjdk11:latest
WORKDIR /home
COPY /target/kafka-demo-0.0.1-SNAPSHOT.jar kafka-demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo-docker.jar"]

