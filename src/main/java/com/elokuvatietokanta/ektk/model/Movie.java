package com.elokuvatietokanta.ektk.model;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Long id;

    @Column(name = "movieName", nullable = false)
    private String movieName;

    @Column(name = "year", nullable = false)
    private int year;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Category category;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    @JsonManagedReference
    private List<Rating> ratings;



    public Movie() {
    }

    public Movie(Long id, String movieName, int year, Category category) {
        this.id = id;
        this.movieName = movieName;
        this.year = year;
        this.category = category;
    }

    public Movie(String movieName, int year, Category category, List<Rating> ratings) {
        this.movieName = movieName;
        this.year = year;
        this.category = category;
        this.ratings = ratings;
    }

    public Movie(String movieName, int year, Category category) {
        this.movieName = movieName;
        this.year = year;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", year=" + year +
                ", id=" + id +
                ", category=" + category +
                '}';
    }
}
