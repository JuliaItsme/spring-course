INSERT INTO Person(name, age, email, date_of_birth)
VALUES ('Julia', 39, 'juligo04@gmail.com', '12-08-1983'),
       ('Olga', 19, 'olgahotova@gmail.com', '28/02/2003'),
       ('Mikhail', 16, 'mikhailhotova@gmail.com', '26/09/2006');

INSERT INTO item(person_id, item_name)
VALUES (2, 'Apple_Watch'),
       (2, 'Iphone_12'),
       (2, 'Ipod'),
       (3, 'PlayStation'),
       (3, 'Samsung_phone'),
       (3, 'PC'),
       (3, 'Tablet'),
       (3, 'Headphone'),
       (1, 'Clock'),
       (1, 'Laptop');


INSERT INTO Director(name, age)
VALUES ('Quentin Tarantino', 57),
       ('Martin Scorsese', 78),
       ('Guy Ritchie', 52),
       ('Woody Allen', 85),
       ('David Lynch', 74),
       ('Christopher Nolan', 50);

INSERT INTO Movie(director_id, name, year_of_production)
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

INSERT INTO Citizen(name, age)
VALUES ('Bob', 12),
       ('Tom', 24),
       ('Katy', 39),
       ('Alice', 45);

INSERT INTO Passport(citizen_id, passport_number)
VALUES (1, 12345),
       (2, 75124),
       (3, 91245),
       (4, 19259);


INSERT INTO Actor(name, age)
VALUES ('Harvey Keitel', 81),
       ('Robert De Niro', 77),
       ('Leonardo DiCaprio', 46),
       ('Jason Statham', 53),
       ('Joe Pesci', 77),
       ('Samuel L. Jackson', 72);

INSERT INTO Actor_Movie
VALUES (1, 1),
       (1, 2),
       (2, 5),
       (2, 6),
       (3, 4),
       (3, 7),
       (3, 11),
       (4, 8),
       (4, 9),
       (5, 6),
       (6, 2),
       (6, 3);