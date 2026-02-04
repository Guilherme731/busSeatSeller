# Estágio de Build
FROM maven:3.9.4-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Estágio de Execução
FROM eclipse-temurin:21-jdk
COPY --from=build /target/busSeatSeller-0.0.1-SNAPSHOT.jar busSeatSeller-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "busSeatSeller-0.0.1-SNAPSHOT.jar"]