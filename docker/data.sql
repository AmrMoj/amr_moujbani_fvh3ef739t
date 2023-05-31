CREATE DATABASE IF NOT EXISTS SCHOOL_MANAGEMENT;

USE SCHOOL_MANAGEMENT;

CREATE TABLE person
(
    id           INT AUTO_INCREMENT NOT NULL,
    person       VARCHAR(31)        NULL,
    first_name   VARCHAR(30)        NULL,
    last_name    VARCHAR(30)        NULL,
    classroom_id INT                NULL,
    CONSTRAINT pk_person PRIMARY KEY (id)
);



CREATE TABLE classroom
(
    id         INT AUTO_INCREMENT NOT NULL,
    class_name VARCHAR(40)        NULL,
    teacher_id INT                NULL,
    CONSTRAINT pk_classroom PRIMARY KEY (id)
);

ALTER TABLE person
    ADD CONSTRAINT FK_PERSON_ON_CLASSROOM FOREIGN KEY (classroom_id) REFERENCES classroom (id);

ALTER TABLE classroom
    ADD CONSTRAINT FK_CLASSROOM_ON_TEACHER FOREIGN KEY (teacher_id) REFERENCES person (id);



INSERT INTO person(person, first_name, last_name) VALUES ("Teacher","David", "Gilmour");
INSERT INTO person(person, first_name, last_name) VALUES ("Teacher","Zack", "Trujillo");
INSERT INTO person(person, first_name, last_name) VALUES ("Teacher","Alexandre", "Tranv");
INSERT INTO person(person, first_name, last_name) VALUES ("Teacher","Libby", "Ferguson");
INSERT INTO person(person, first_name, last_name) VALUES ("Student","Mateo", "Hodges");
INSERT INTO person(person, first_name, last_name) VALUES ("Student","Alyssia", "Kerr");
INSERT INTO person(person, first_name, last_name) VALUES ("Student","Dana", "Vasquez");
INSERT INTO person(person, first_name, last_name) VALUES ("Student","Harri", "Hawkins");

INSERT INTO classroom(class_name) VALUES ("Java");
INSERT INTO classroom(class_name) VALUES ("Spring Framework");
INSERT INTO classroom(class_name) VALUES ("Softwar Architecture");
INSERT INTO classroom(class_name) VALUES ("Design Patters");
