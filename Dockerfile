FROM openjdk:8
VOLUME /tmp
ADD ./target/microservice_user-0.0.1-SNAPSHOT.jar microservice_user.jar
ENTRYPOINT ["java","-jar","/microservice_user.jar"]