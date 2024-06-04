FROM maven:3.9-amazoncorretto-17 AS build
WORKDIR /clustereddatawarehouse
COPY pom.xml .
RUN mvn dependency:go-offline
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:20
WORKDIR /clustereddatawarehouse
COPY --from=build /clustereddatawarehouse/target/clustereddatawarehouse-0.1.jar .
EXPOSE 8080
CMD ["java", "-jar", "clustereddatawarehouse-0.1.jar"]
