FROM amazoncorretto:17
LABEL maintainer="prudv.raj06@gmail.com"
WORKDIR /app
COPY target/BlogApplication-0.0.1-SNAPSHOT.jar /app/springboot-blogapp.jar
ENTRYPOINT ["java", "-jar", "springboot-blogapp.jar"]