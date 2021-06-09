FROM registry.gitlab.com/armdev/dockers/openjdk15

COPY target/courses.jar /opt/courses.jar
ENTRYPOINT ["java", "-jar","/opt/courses.jar"]

EXPOSE 9096



