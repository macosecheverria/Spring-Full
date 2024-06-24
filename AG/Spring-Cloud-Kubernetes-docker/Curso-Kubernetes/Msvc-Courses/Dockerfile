FROM openjdk:17-alpine as builder

WORKDIR /app/Msvc-Courses

COPY  ./pom.xml /app
COPY ./Msvc-Courses/.mvn ./.mvn
COPY ./Msvc-Courses/mvnw .
COPY ./Msvc-Courses/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
COPY ./Msvc-Courses/src ./src
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-alpine

COPY --from=builder /app/Msvc-Courses/target/Msvc-Courses-0.0.1-SNAPSHOT.jar .

EXPOSE 8002

ENTRYPOINT ["java", "-jar", "Msvc-Courses-0.0.1-SNAPSHOT.jar"]


#FROM openjdk
#WORKDIR /app
#COPY ./target/Msvc-Courses-0.0.1-SNAPSHOT.jar .
#EXPOSE 8002
#ENTRYPOINT ["java", "-jar", "Msvc-Courses-0.0.1-SNAPSHOT.jar"]