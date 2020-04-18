package com.elokuvatietokanta.ektk.controller;


import com.elokuvatietokanta.ektk.model.Movie;
import com.elokuvatietokanta.ektk.model.Rating;
import com.elokuvatietokanta.ektk.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class RestMovieController {


    private static final Logger log = LoggerFactory.getLogger(MovieController.class);

    final
    MovieRepository movieRepository;

    public RestMovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }



    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public @ResponseBody
    List<Movie> returnRestMovieList() {
        return (List<Movie>) movieRepository.findAll();
    }


    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public @ResponseBody
    Movie saveMovieRest(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @RequestMapping(value = "/movielist", method = RequestMethod.POST)
    public @ResponseBody
    List<Movie> saveMovieListRest(@RequestBody List<Movie> movie) {
        return (List<Movie>) movieRepository.saveAll(movie);
    }

    @RequestMapping(value = "/movies", method = RequestMethod.PUT)
    public @ResponseBody
    Movie editMovieRest(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @RequestMapping(value = "/addrating/movieid={id}", method = RequestMethod.PUT)
    public @ResponseBody
    Optional<Movie> editMovieRest(@PathVariable Long id, @RequestBody List<Rating> rating) {

        return movieRepository.findById(id)
                .map(movie1 -> {
                    movie1.setRatings(rating);
                    return movieRepository.save(movie1);
                });
    }

    @RequestMapping(value = "/movies", method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteMovieRest(@RequestBody Movie movie) {
        movieRepository.delete(movie);
    }

    @RequestMapping(value = "/movies/{name}", method = RequestMethod.GET)
    public @ResponseBody
    Movie returnMovieByName(@PathVariable("name") String name) {
        if (movieRepository.findMovieByPartOfNameNonCaseSensitive(name) != null) {
            return movieRepository.findMovieByPartOfNameNonCaseSensitive(name);
        } else return new Movie();
    }

}
