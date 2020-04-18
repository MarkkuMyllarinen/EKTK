package com.elokuvatietokanta.ektk.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String name;


    @OneToMany
    @JsonIgnore
    @JoinColumn
    private List<Movie> movies;

    public Category() {
    }

    public Category(String name) {
        super();
        this.name = name;
    }

    public Category(Long categoryId, String name, List<Movie> movies) {
        this.categoryId = categoryId;
        this.name = name;
        this.movies = movies;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }
}
