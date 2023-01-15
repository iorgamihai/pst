FROM maven AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11-jdk
COPY --from=build /home/app/target/ecommerce-0.0.1-SNAPSHOT.jar /usr/src/myapp/app.jar
WORKDIR /usr/src/myapp

EXPOSE 7000
ENTRYPOINT ["java",ls "-jar", "app.jar"]