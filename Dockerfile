FROM eclipse-temurin:17-jdk-alpine
#VOLUME /tmp
COPY build/libs/*.jar app.jar
#EXPOSE ${PORT}
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar","-Djava.net.preferIPv4Stack=true","-Djava.net.preferIPv6Addresses=false"]
