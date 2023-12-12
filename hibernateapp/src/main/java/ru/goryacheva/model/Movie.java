package ru.goryacheva.model;

import javax.persistence.*;

@Entity
@Table(name="Movie")
public class Movie {

    @Id
    @Column(name="movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String nameMovie;

    @Column(name="year_of_production")
    private int yearOfProduction;

    @ManyToOne
    @JoinColumn(name="director_id", referencedColumnName = "director_id")
    private Director director;

    public Movie() {
    }

    public Movie(String nameMovie, int yearOfProduction) {
        this.nameMovie = nameMovie;
        this.yearOfProduction = yearOfProduction;
    }

    public Movie(String nameMovie, int yearOfProduction, Director director) {
        this.nameMovie = nameMovie;
        this.yearOfProduction = yearOfProduction;
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", nameMovie='" + nameMovie + '\'' +
                ", yearOfProduction=" + yearOfProduction + ", director=" + director + '}';
    }
}
