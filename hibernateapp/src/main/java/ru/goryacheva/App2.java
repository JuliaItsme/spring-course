package ru.goryacheva;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.goryacheva.model.Director;
import ru.goryacheva.model.Movie;

import java.util.List;

public class App2 {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//2
            /*Director director = session.get(Director.class, 3);
            List<Movie> list = director.getMovieList();
            director.toStringList(list);*/

//3
           /* Movie movie = session.get(Movie.class, 3);
            System.out.println(movie.getDirector());*/

//4
           /* Director director = session.get(Director.class, 6);
            Movie movie = new Movie("Interstellar", 2014, director);

            //обновление в кэше
            director.addMovie(movie);

            session.save(movie);*/


//5
            /*Director director = new Director("Taylor Sheridan", 52);

            Movie movie = new Movie("Wind River", 2017, director);
            director.addMovie(movie);
            session.save(director);
            session.save(movie);*/

            /*Director director = session.get(Director.class, 7);
            director.setAge(52);
            session.update(director);*/

//6

          /* Director director = session.get(Director.class, 8);
            Movie movie = session.get(Movie.class, 13);

            movie.getDirector().getMovieList().remove(movie);

            movie.setDirector(director);
            director.addMovie(movie);

            session.update(movie);*/
//7
          /*  Director director = session.get(Director.class, 8);
           // director.getMovieList().forEach(session::remove);
            director.getMovieList().forEach(m -> m.setDirector(null));
            director.getMovieList().clear();*/

            session.getTransaction().commit();
        }
        System.out.println("Good day, Julia!");
    }
}
