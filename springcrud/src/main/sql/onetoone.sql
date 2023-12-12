-- не можем назначить одному человеку несколько паспортов
INSERT INTO Passport(citizen_id, passport_number) VALUES (3, 12455);

-- и также не можем назначить паспорт несуществующему человеку
INSERT INTO Passport(citizen_id, passport_number) VALUES (10, 12455);

-- Inner Join
SELECT name, passport_number FROM citizen JOIN passport ON citizen.citizen_id = passport.citizen_id;

-- LEFT JOIN
-- Добавим человека без паспорта
INSERT INTO Citizen(name, age) VALUES ('Jane', 1);
SELECT name, passport_number FROM citizen LEFT JOIN passport ON citizen.citizen_id = passport.citizen_id;
