package com.elokuvatietokanta.ektk.repository;

import com.elokuvatietokanta.ektk.model.Movie;

import java.util.List;

public interface CustomMovieRepository {
    public Movie findMovieByPartOfNameNonCaseSensitive(String movieName);
}
