DROP TABLE Person;
DROP TABLE Item;

ALTER TABLE person ADD COLUMN address VARCHAR NOT NULL;

--просто дата без точного времени
ALTER TABLE Person ADD COLUMN date_of_birth DATE;

--точное время
--значения timestamp сохраняются в секундах до или после полуночи 1 января 2000
ALTER TABLE Person ADD COLUMN created_at TIMESTAMP;
ALTER TABLE Person ADD COLUMN mood INT;

select * from item;