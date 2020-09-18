FROM anapsix/alpine-java:latest 
COPY target/BookInventory-0.0.1-SNAPSHOT.jar app.jar 
EXPOSE 9002 
ENTRYPOINT java -jar ./app.jar
