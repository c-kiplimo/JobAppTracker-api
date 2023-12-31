FROM adoptopenjdk/openjdk11:alpine-jre

ADD target/jobAppTracker-api-0.0.1-SNAPSHOT.jar  jobAppTracker-api-0.0.1-SNAPSHOT.jar

RUN ls -ltrh /

# default environment
ENV JVM_OPTS=""

ENV SPRING_OPTS=""

ENTRYPOINT ["java", "-jar", "/jobAppTracker-api-0.0.1-SNAPSHOT.jar"]

EXPOSE 8081