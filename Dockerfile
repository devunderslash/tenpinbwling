FROM maven:3.6.1-jdk-8-alpine AS MAVEN_BUILD

# copy the pom and src code to the container
COPY ./ ./

# package our application code
RUN mvn clean package

# the second stage of our build will use open jdk 8 on alpine 3.9
FROM openjdk:8-jre-alpine3.9

# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD /bowling/target/bowling-0.0.1-SNAPSHOT.jar /bowling.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "/bowling.jar"]

#docker build -t bowling:1.0-SNAPSHOT .
#docker run -d -p 5005:5005 bowling:1.0-SNAPSHOT
