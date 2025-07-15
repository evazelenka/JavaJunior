FROM openjdk:17

COPY out/artifacts/javajunior_jar/javajunior.jar /tmp/javajunior.jar
WORKDIR /tmp
CMD ["java", "-jar", "/tmp/javajunior.jar"]