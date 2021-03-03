FROM openjdk:11
EXPOSE 8092
ADD target/My-app-ws.jar My-app-ws.jar
ENTRYPOINT ("java","-jar","My-app-ws.jar")
