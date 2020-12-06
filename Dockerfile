FROM openjdk:11 as build
ADD . /opt/my-bank
WORKDIR /opt/my-bank
RUN ./gradlew clean b

FROM openjdk:11
COPY --from=build /opt/my-bank/build/libs/*.jar /opt/my-bank/my-bank.jar
CMD ["java", "-jar", "/opt/my-bank/my-bank.jar"]
