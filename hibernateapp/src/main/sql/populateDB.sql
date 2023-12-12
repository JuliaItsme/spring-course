TRUNCATE Person RESTART IDENTITY CASCADE;

INSERT INTO person(name, age)
VALUES ('Helga', 18),
       ('Mikhail', 29),
       ('Dmitry', 43),
       ('John', 35);

INSERT INTO item(person_id, item_name)
VALUES (1, 'Ipod'),
       (1, 'AppleWatch'),
       (2, 'PlayStation'),
       (3, 'Samsung'),
       (4, 'AirPods'),
       (4, 'Iphone');


TRUNCATE principal RESTART IDENTITY CASCADE;

INSERT INTO principal(name, age)
VALUES ('Bob', 54),
       ('Tom', 61),
       ('Katy', 39),
       ('Alice', 45);

INSERT INTO school(school_number, principal_id)
VALUES (7, 3),
       (131, 1),
       (18, 2),
       (39, 4);


TRUNCATE director RESTART IDENTITY CASCADE;

INSERT INTO director(name, age)
VALUES ('Quentin Tarantino', 57),
       ('Martin Scorsese', 78),
       ('Guy Ritchie', 52),
       ('Woody Allen', 85),
       ('David Lynch', 74),
       ('Christopher Nolan', 50);

INSERT INTO movie(director_id, name, year_of_production)
VALUES (1, 'Reservoir Dogs', 1992),
       (1, 'Pulp Fiction', 1994),
       (1, 'The Hateful Eight', 2015),
       (1, 'Once Upon a Time in Hollywood', 2019),
       (2, 'Taxi Driver', 1976),
       (2, 'Goodfellas', 1990),
       (2, 'The Wolf of Wall Street', 2013),
       (3, 'Lock, Stock and Two Smoking Barrels', 1998),
       (3, 'Snatch', 2000),
       (4, 'Midnight in Paris', 2011),
       (6, 'Inception', 2010);