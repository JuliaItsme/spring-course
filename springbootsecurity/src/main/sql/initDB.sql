DROP TABLE IF EXISTS Person;

CREATE TABLE Person
(
    id            INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    username      VARCHAR(100) NOT NULL,
    year_of_birth INT          NOT NULL,
    password      VARCHAR      NOT NULL
);