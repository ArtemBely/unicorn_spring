#Test unicorn project
#spring.main.allow-circular-references=true from properties

# Steps for launch project:

# install and configure postgresql.

# configure application.yml by using postgresql:
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/<your-name-of-db>
    username: <username>
    password: <password>

# create table in SQL CMD Terminal with follow schema and data types:
create table product(
 ID: SERIAL PRIMARY KEY,
 CONTENT: VARCHAR(20) NOT NULL,
 STATE: VARCHAR(10) NOT NULL,
 COUNT: INTEGER NOT NULL
);

### ! Not necessary to use json-server in this project !

*not necessary
# add via Postman couple of products
INSERT INTO product(content, state, count) VALUES('Chicken', 'ACTIVE', 1);
INSERT INTO product(content, state, count) VALUES('Water', 'ACTIVE', 2);

# launch app 

# launch FrontEnd on port 3000 after installing all dependencies
