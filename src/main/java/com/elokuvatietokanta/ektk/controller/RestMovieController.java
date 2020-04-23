package com.elokuvatietokanta.ektk.controller;


import com.elokuvatietokanta.ektk.model.Category;
import com.elokuvatietokanta.ektk.model.Movie;
import com.elokuvatietokanta.ektk.model.Rating;
import com.elokuvatietokanta.ektk.repository.CategoryRepository;
import com.elokuvatietokanta.ektk.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class RestMovieController {


    private static final Logger log = LoggerFactory.getLogger(MovieController.class);

    final
    MovieRepository movieRepository;

    final
    CategoryRepository categoryRepository;

    public RestMovieController(MovieRepository movieRepository, CategoryRepository categoryRepository) {
        this.movieRepository = movieRepository;
        this.categoryRepository = categoryRepository;
    }


    @RequestMapping(value = "/api/movies", method = RequestMethod.GET)
    public @ResponseBody
    List<Movie> returnRestMovieList() {
        return (List<Movie>) movieRepository.findAll();
    }


    @RequestMapping(value = "/api/movies", method = RequestMethod.POST)
    public @ResponseBody
    Movie saveMovieRest(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @RequestMapping(value = "/api/movielist", method = RequestMethod.POST)
    public @ResponseBody
    List<Movie> saveMovieListRest(@RequestBody List<Movie> movie) {
        return (List<Movie>) movieRepository.saveAll(movie);
    }

    @RequestMapping(value = "/api/movies", method = RequestMethod.PUT)
    public @ResponseBody
    Movie editMovieRest(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @RequestMapping(value = "/api/addrating/movieid={id}", method = RequestMethod.PUT)
    public @ResponseBody
    Optional<Movie> editMovieRest(@PathVariable Long id, @RequestBody List<Rating> rating) {

        Movie movie = movieRepository.findMovieById(id);

        List<Rating> temp = movie.getRatings();

        temp.addAll(rating);

        return movieRepository.findById(id)
                .map(movie1 -> {
                    movie1.setRatings(temp);
                    movie1.setAvarageRating();
                    return movieRepository.save(movie1);
                });
    }

    @RequestMapping(value = "/api/movies", method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteMovieRest(@RequestBody Movie movie) {
        movieRepository.delete(movie);
    }

    @RequestMapping(value = "/api/addcategorylist", method = RequestMethod.POST)
    public @ResponseBody
    List<Category> addCategoryList(@RequestBody List<Category> categories){

       return (List<Category>) categoryRepository.saveAll(categories);

    }

    @RequestMapping(value = "/api/movies/{name}", method = RequestMethod.GET)
    public @ResponseBody
    Movie returnMovieByName(@PathVariable("name") String name) {
        if (movieRepository.findMovieByPartOfNameNonCaseSensitive(name) != null) {
            return movieRepository.findMovieByPartOfNameNonCaseSensitive(name);
        } else return new Movie();
    }

}
