-- Пробуем вставить дубликат по двум колонкам - ошибка
INSERT INTO Actor_Movie
VALUES (6, 3);

-- Чтобы узнать, какой актер снимался в каком фильме, нам надо сделать два Join'а
-- Join для случая отношения Многие ко многим
SELECT Actor.name, Movie.name
FROM Actor
         JOIN actor_movie ON actor.actor_id = actor_movie.actor_id
         JOIN movie ON actor_movie.movie_id = movie.movie_id;

SELECT Actor.name, Movie.name, Director.name
FROM Actor
         JOIN actor_movie ON actor.actor_id = actor_movie.actor_id
         JOIN movie ON actor_movie.movie_id = movie.movie_id
         JOIN director ON Director.director_id = movie.director_id;