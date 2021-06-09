FROM registry.gitlab.com/armdev/dockers/openjdk15

COPY target/gateway.jar /opt/gateway.jar
ENTRYPOINT ["java", "-jar","/opt/gateway.jar"]

EXPOSE 9097



