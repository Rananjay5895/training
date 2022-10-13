--liquibase fomatted sql
--changeset rananjay: 1
create table Subscriber (
id int IDENTITY NOT NULL PRIMARY KEY,
email varchar(255),
first_name varchar(255),
last_name varchar(255)
)