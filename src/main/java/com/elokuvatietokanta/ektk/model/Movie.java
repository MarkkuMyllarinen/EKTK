package com.elokuvatietokanta.ektk.model;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

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


    private double avarageRating = 0.0;


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


    public Double getAvarageRating() {

        return this.avarageRating;
    }

    public Double calculateAvarageRating() {

        int value = 0;

        for (Rating rating : ratings) {
            value = rating.getValue() + value;
        }

        if (ratings.size() > 0) {
            DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.GERMAN);
            otherSymbols.setDecimalSeparator('.');
            otherSymbols.setGroupingSeparator('.');
            DecimalFormat df = new DecimalFormat("#.0", otherSymbols);
            Double temp = 1.0 * value / ratings.size();
            String formatted = df.format(temp);
            return Double.valueOf(formatted);
        } else return 0.0;

    }

    public void setAvarageRating() {
        this.avarageRating = calculateAvarageRating();
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
