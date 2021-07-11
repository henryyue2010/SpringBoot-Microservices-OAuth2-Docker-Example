FROM openjdk:8-jdk-alpine

ADD ["build/libs/api-gateway-0.0.1-SNAPSHOT.jar", "app.jar"]
EXPOSE 8080
# ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8787,suspend=n"
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=production -jar /app.jar" ]