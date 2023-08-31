 #which "oficial Java image"?
FROM openjdk:17-jdk-alpine
#working directory
WORKDIR /app
#copy from your local machine to the container
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
#run this inside the image
RUN ./mvnw dependency:go-offline
COPY src ./src
#run this inside container
CMD ["./mvnw", "spring-boot:run"]


