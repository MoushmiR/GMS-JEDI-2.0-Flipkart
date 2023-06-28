FROM jfrog.fkinternal.com/fk-base-images/adoptopenjdk/jdk:8u322-debian11.3-slim-20220527

WORKDIR /flipfit

COPY target/flipfit_d-1.0-SNAPSHOT.jar /flipfit/code.jar

COPY src/main/resources/config_local.yaml /flipfit/config_local.yaml

EXPOSE 8080

ENTRYPOINT ["java","-jar","code.jar","server","/etc/config/config_local.yaml"]