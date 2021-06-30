FROM postgres

RUN mkdir -p /opt/postgres
WORKDIR /opt/postgres

ADD build/libs/toolshed_service.jar toolshed_service.jar
ADD configuration.yml configuration.yml

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "toolshed_service.jar"]
CMD ["server", "configuration.yml"]
