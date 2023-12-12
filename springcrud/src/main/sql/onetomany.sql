SELECT * FROM director;

SELECT * FROM movie;

-- У режиссера с id=5 нет ни одного фильма в нашей БД

-- пробуем вставить фильм с несуществующим режиссером - ПОЛУЧАЕМ ОШИБКУ (на это и нужна REFERENCES)
INSERT INTO Movie(director_id, name, year_of_production) VALUES (7, 'bla bla', 2020);

-- Join'им
-- Выводим всех режиссеров, у которых есть фильмы и для каждого режиссера выводим его фильмы
SELECT * FROM Director JOIN Movie ON Director.director_id = Movie.director_id;

-- Выводим только полезную информацию
SELECT Director.name, Movie.name FROM director JOIN movie ON Director.director_id = Movie.director_id;

-- ! В таблицах Movie и Director строки могут располагаться в любом порядке, JOIN в любом случае спарит нужные строки по условию

-- LEFT JOIN
SELECT Director.name, Movie.name FROM director LEFT JOIN Movie ON Director.director_id = Movie.director_id;
-- Появился Дэвид Линч, у которого нет фильма в нашей БД.