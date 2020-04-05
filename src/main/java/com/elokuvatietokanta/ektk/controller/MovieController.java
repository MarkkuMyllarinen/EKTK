package com.elokuvatietokanta.ektk.controller;

import com.elokuvatietokanta.ektk.model.Movie;
import com.elokuvatietokanta.ektk.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MovieController{

    private static final Logger log = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    MovieRepository movieRepository;


    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public @ResponseBody
    List<Movie> returnRestMovieList() {
        return (List<Movie>) movieRepository.findAll();
    }

    @RequestMapping(value = "/movies/{name}", method = RequestMethod.GET)
    public @ResponseBody
    Movie returnMovieByName(@PathVariable("name") String name) {
        return movieRepository.findMovieByPartOfNameNonCaseSensitive(name);
    }


}
