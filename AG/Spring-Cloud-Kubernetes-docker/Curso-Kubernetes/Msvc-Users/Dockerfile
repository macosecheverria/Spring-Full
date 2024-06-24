FROM openjdk:17-jdk-alpine as builder

ARG MSVC-NAME=Msvc-Users

WORKDIR /app/Msvc-Users

COPY  ./pom.xml /app
COPY ./Msvc-Users/.mvn ./.mvn
COPY ./Msvc-Users/mvnw .
COPY ./Msvc-Users/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
COPY ./Msvc-Users/src ./src
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine
WORKDIR /app
RUN mkdir ./logs

ARG MSVC-NAME=Msvc-Users

ARG TARGET_FOLDER=/app/Msvc-Users/target

COPY --from=builder /app/Msvc-Users/target/Msvc-Users-0.0.1-SNAPSHOT.jar .

ENV PORT=8001

EXPOSE ${PORT}

CMD ["java", "-jar", "Msvc-Users-0.0.1-SNAPSHOT.jar"]

#FROM openjdk
#WORKDIR /app
#COPY ./target/Msvc-Users-0.0.1-SNAPSHOT.jar .
#EXPOSE 8001
#ENTRYPOINT ["java", "-jar", "Msvc-Users-0.0.1-SNAPSHOT.jar"]


#FROM openjdk
#WORKDIR /app/msvc-users
#COPY  ./pom.xml /app
#COPY ./Msvc-Users/.mvn ./.mvn
#COPY ./Msvc-Users/mvnw .
#COPY ./Msvc-Users/pom.xml .
#RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline
#COPY ./Msvc-Users/src ./src
#RUN ./mvnw clean package -DskipTests
#EXPOSE 8001
#ENTRYPOINT ["java", "-jar", "./target/Msvc-Users-0.0.1-SNAPSHOT.jar"]