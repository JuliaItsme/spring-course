TRUNCATE Person RESTART IDENTITY;

INSERT INTO Person (username, year_of_birth, "password")
VALUES ('Julia', 1993, 'julia'),
       ('Olga', 2003, 'olga'),
       ('Mikhail', 2013, 'mikhail');