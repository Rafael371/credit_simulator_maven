FROM eclipse-temurin:20

RUN mkdir /opt/app
COPY credit_simulation_maven.jar /opt/app
CMD ["java", "-jar", "/opt/app/credit_simulation_maven.jar"]