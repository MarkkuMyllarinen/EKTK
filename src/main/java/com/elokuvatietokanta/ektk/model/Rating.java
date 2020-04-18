package com.elokuvatietokanta.ektk.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn
    private Long id;

    private Integer value;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Movie movie;


    public Rating() {
    }

    public Rating(Integer value) {
        this.value = value;
    }

    public Rating(Integer value, Movie movie) {
        this.value = value;
        this.movie = movie;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}