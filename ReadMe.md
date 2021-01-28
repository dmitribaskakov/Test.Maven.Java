Camel Java Router Project
=========================

To build this project use

    mvn install

To run this project from within Maven use

    mvn exec:java

For more help see the Apache Camel documentation

    http://camel.apache.org/

# Power Shell with Docker

    docker run -it --name powershell --rm -v c:/Projects/SharedData:/shareddata mcr.microsoft.com/powershell

`Ctrl-P-Q`

    docker stop powershell


# PostgreSQL with Docker
- https://www.youtube.com/watch?v=A8dErdDMqb0
-------

## 1: Create a Postgres docker container
    docker run --name db -d --rm -v c:/Projects/Test.Maven.Java/db/data:/var/lib/postgresql/data -e TZ=Asia/Novosibirsk -e POSTGRES_PASSWORD=password postgres
    docker ps -a
    docker stop db

## 2: Connect and run some queries
    docker exec -it db psql -U postgres
    CREATE DATABASE demo_db1;
    \c demo_db1;
    CREATE TABLE demo_t(something int);
    INSERT INTO demo_t (something) VALUES (1);
    \dt;
    select * from demo_t;
    \q

## 3: Automate - run scripts using docker cli
run sql scripts from your host machine/dev machine etc

    docker run --name db -d --rm -v c:/Projects/Test.Maven.Java/db/data:/var/lib/postgresql/data -v c:/Projects/Test.Maven.Java/db/scripts:/etc/postgresql/scripts -e TZ=Asia/Novosibirsk -e POSTGRES_PASSWORD=password postgres
    docker exec -it db psql -U postgres -c "CREATE DATABASE demo_db2"
    docker exec -it db psql -U postgres -f /etc/postgresql/scripts/datascript_db1.sql

