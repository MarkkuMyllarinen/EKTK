package com.elokuvatietokanta.ektk.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {


    @Column(name = "movieName", nullable = false)
    private String movieName;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "studio")
    private String studioName;

    @Column(name = "rating", nullable = false)
    private float rating;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "categoryId")
    private Category category;


    public Movie() {
    }

    public Movie(String movieName, int year, float rating, Category category) {
        this.movieName = movieName;
        this.year = year;
        this.rating = rating;
        this.category = category;
    }

    public Movie(String movieName, int year, String studioName, float rating, Category category) {
        this.movieName = movieName;
        this.year = year;
        this.studioName = studioName;
        this.rating = rating;
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

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
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
