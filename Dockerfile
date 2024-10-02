FROM openjdk:17-jdk

WORKDIR /app

COPY target/LibraryManagement-1.0.0.jar /app/LibraryManagement.jar

EXPOSE 3600

CMD ["java", "-jar", "LibraryManagement.jar"] 