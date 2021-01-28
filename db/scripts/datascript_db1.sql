CREATE DATABASE demo_db1;
CREATE USER trackuser WITH PASSWORD 'trackuser';
GRANT ALL PRIVILEGES ON DATABASE demo_db1 to trackuser;
CREATE TABLE demo_t(something int);
INSERT INTO demo_t (something) VALUES (1);
