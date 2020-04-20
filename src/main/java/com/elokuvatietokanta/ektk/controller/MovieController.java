package com.elokuvatietokanta.ektk.controller;

import com.elokuvatietokanta.ektk.model.Movie;
import com.elokuvatietokanta.ektk.repository.CategoryRepository;
import com.elokuvatietokanta.ektk.repository.MovieRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MovieController {


    private final MovieRepository movieRepository;
    private final CategoryRepository categoryRepository;

    public MovieController(MovieRepository movieRepository, CategoryRepository categoryRepository) {
        this.movieRepository = movieRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("/")
    public String getIndexPage(){
        return "redirect:/login";
    }


    @PreAuthorize("hasRole('ADMIN')")
    //endpoint for thymeleaf movie adding form
    @RequestMapping(value = "/newmovie", method = RequestMethod.GET)
    public String getNewMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("categories", categoryRepository.findAll());
        return "movieform";
    }


    //endpoint for thymeleaf movie adding form
    @RequestMapping(value = "/newmovie", method = RequestMethod.POST)
    public String saveNewBook(@ModelAttribute Movie movie) {
        movieRepository.save(movie);
        return "redirect:/api/movies";
    }


}
