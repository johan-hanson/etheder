# Etheder

## Prerequisites
Java 11
Maven
PostgreSQL
Docker

### Start PostgreSQL
docker run -d  --mount source=postgres-vol,target=/var/lib/pgsql/data --name postgresql_database -e POSTGRESQL_USER=etheder -e POSTGRESQL_PASSWORD=Ethederpass -e POSTGRESQL_DATABASE=etheder -p 5432:5432 centos/postgresql-96-centos7

### Configuring application
Application configuration (configuration.yml) contains fields that can be overriden by envType variables. 
To run locally against docker dependencies set the following envType variables: (Can be set in runtime configuration):

### Build application
mvn install

### Running locally in IDE

#### 1. Initialize the database
Run mainclass ApiApplication.java with arguments
```init-startdata configuration.yml```

#### 2. Start
Run mainclass ApiApplication.java with arguments 
```server configuration.yml```






