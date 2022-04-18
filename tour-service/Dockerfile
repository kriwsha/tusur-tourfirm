FROM openjdk:11
ADD . /src
WORKDIR /src
RUN ./mvn package -DskipTests
EXPOSE 8080
CMD ["java","-jar","target/tour-service-0.0.1-SNAPSHOT.jar"]

# TODO:
#  1. подумать об уменьшении размера образа
#  2. добавить в pom плагин для изменения названия итогового джарника