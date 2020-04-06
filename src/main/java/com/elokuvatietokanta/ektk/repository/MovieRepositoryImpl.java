package com.elokuvatietokanta.ektk.repository;

import com.elokuvatietokanta.ektk.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MovieRepositoryImpl implements CustomMovieRepository {
    @Autowired
    MovieRepository movieRepository;

    @Override
    public Movie findMovieByPartOfNameNonCaseSensitive(String movieName) {
        List<Movie> movieList = (List<Movie>) movieRepository.findAll();
        for (Movie movie : movieList) {
            boolean isPresent = movie.getMovieName().toLowerCase().indexOf(movieName.toLowerCase()) != -1 ? true : false;
            if (isPresent) return movie;
        }
        return null;
    }
}
