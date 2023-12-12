package ru.goryacheva.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Director")
public class Director {

    @Id
    @Column(name="director_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    @OneToMany(mappedBy = "director")
    private List<Movie> movies;

    public Director() {
    }

    public Director(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Director(String name, int age, List<Movie> movies) {
        this.name = name;
        this.age = age;
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Movie> getMovieList() {
        return movies;
    }

    public void setMovieList(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie) {
        if(this.movies == null)
            this.movies = new ArrayList<>();
        this.movies.add(movie);
        movie.setDirector(this);
    }

    @Override
    public String toString() {
        return "Director {" + " id= " + id + ", name = '" + name + '\'' +
                ", age = " + age + '}';
    }

    public void toStringList(List<Movie> movies){
        movies.forEach(System.out::println);
    }
}
