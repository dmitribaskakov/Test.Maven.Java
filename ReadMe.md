Camel Java Router Project
=========================

To build this project use

    mvn install

To run this project from within Maven use

    mvn exec:java

For more help see the Apache Camel documentation

    http://camel.apache.org/

#Oracle JDBC drivers
1. Visit Oracle database website and download it. https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html
2. Upload or install the downloaded ojdbc.jar into the Maven local repository.


    mvn install:install-file -Dfile=c:/Projects/Test.Maven.Java/lib/ojdbc11.jar -DgroupId=com.oracle.database.jdbc -DartifactId=ojdbc11 -Dversion=21.1.0.0 -Dpackaging=jar
   
3. Now, we can define the Oracle JDBC driver dependency like this pom.xml:


    <dependency>
        <groupId>com.oracle.database.jdbc</groupId>
        <artifactId>ojdbc11</artifactId>
        <version>21.1.0.0</version>
        <!-- <scope>system</scope>  -->
        <!-- <systemPath>${project.basedir}/lib/ojdbc11.jar</systemPath>  -->
    </dependency>

4. install PostgreSQL JDBC Driver

   mvn install -DgroupId=org.postgresql -DartifactId=postgresql -Dversion=42.2.18.jre7

    <dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>postgresql</artifactId>
      <version>42.2.18.jre7</version>
    </dependency>

# Power Shell with Docker

    docker run -it --name powershell --rm -v c:/Projects/SharedData:/shareddata mcr.microsoft.com/powershell

`Ctrl-P-Q`

    docker stop powershell


# PostgreSQL with Docker
- https://www.youtube.com/watch?v=A8dErdDMqb0
-------

## 1: Create a Postgres docker container
    docker run --name db.test.maven.java -d --rm -p 5432:5432 -v c:/Projects/Test.Maven.Java/db/data:/var/lib/postgresql/data -e TZ=Asia/Novosibirsk -e POSTGRES_PASSWORD=password postgres
    docker ps -a
    docker stop db.test.maven.java

## 2: Connect and run some queries
    docker exec -it db.test.maven.java psql -U postgres
    CREATE DATABASE demo_db1;
    \c demo_db1;
    CREATE TABLE demo_t(something int);
    INSERT INTO demo_t (something) VALUES (1);
    \dt;
    select * from demo_t;
    \q

## 3: Automate - run scripts using docker cli
run sql scripts from your host machine/dev machine etc

    docker run --name db.test.maven.java -d --rm -p 5432:5432 -v c:/Projects/Test.Maven.Java/db/data:/var/lib/postgresql/data -v c:/Projects/Test.Maven.Java/db/scripts:/etc/postgresql/scripts -e TZ=Asia/Novosibirsk -e POSTGRES_PASSWORD=password postgres
    docker exec -it db.test.maven.java psql -U postgres -c "CREATE DATABASE demo_db2"
    docker exec -it db.test.maven.java psql -U postgres -f /etc/postgresql/scripts/datascript_db1.sql

