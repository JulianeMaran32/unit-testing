# install the image of th JDK version
FROM openjdk:17-jdk
LABEL authors="juliane.maran"

# path of the working directory
WORKDIR /testing-rest-api

# copy all the files inside the project directory to the container
COPY target/testing-rest-api-0.0.1-SNAPSHOT.jar.jar ./

# execute a command-line inside the container: mvn clean install to install the dependencies in pom.xml.
RUN mvn clean install

# run script mvn spring-boot:run after the image is built.
CMD mvn spring-boot:run

ENTRYPOINT ["java", "-jar", "testing-rest-api-0.0.1-SNAPSHOT.jar"]