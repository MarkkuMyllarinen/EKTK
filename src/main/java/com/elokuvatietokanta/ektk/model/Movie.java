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

    @Column(name = "rating", nullable = false)
    private float rating;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;


    public Movie() {
    }

    public Movie(Long id, String movieName, int year, float rating, Category category) {
        this.id = id;
        this.movieName = movieName;
        this.year = year;
        this.rating = rating;
        this.category = category;
    }

    public Movie(String movieName, int year, float rating, Category category) {
        this.movieName = movieName;
        this.year = year;
        this.rating = rating;
        this.category = category;
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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", id=" + id +
                ", category=" + category +
                '}';
    }
}
