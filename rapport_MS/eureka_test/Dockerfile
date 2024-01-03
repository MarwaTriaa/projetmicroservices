FROM openjdk:8
EXPOSE 8761
ADD target/eureka_test-0.0.1-SNAPSHOT.jar eureka.jar
ENTRYPOINT ["java", "-jar", "eureka.jar"]