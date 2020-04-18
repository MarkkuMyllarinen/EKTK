package com.elokuvatietokanta.ektk;

import com.elokuvatietokanta.ektk.model.Category;
import com.elokuvatietokanta.ektk.model.Movie;
import com.elokuvatietokanta.ektk.model.Rating;
import com.elokuvatietokanta.ektk.repository.CategoryRepository;
import com.elokuvatietokanta.ektk.repository.MovieRepository;
import com.elokuvatietokanta.ektk.repository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

import java.awt.dnd.DragSource;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class EktkApplication {

    private static final Logger log = LoggerFactory.getLogger(EktkApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EktkApplication.class, args);
    }



    @Bean
    public CommandLineRunner ektkDemo(CategoryRepository categoryRepository, MovieRepository movieRepository, RatingRepository ratingRepository) {
        return (args) -> {




            log.info("lisätään testidataa");

            categoryRepository.save(new Category("Toiminta"));
            categoryRepository.save(new Category("Seikkailu"));
            categoryRepository.save(new Category("Huumori"));
            categoryRepository.save(new Category("Rikos"));
            categoryRepository.save(new Category("Draama"));
            categoryRepository.save(new Category("Fantasia"));
            categoryRepository.save(new Category("Kauhu"));
            categoryRepository.save(new Category("Trilleri"));
            categoryRepository.save(new Category("Länkkäri"));




            movieRepository.save(new Movie("The Shawshank Redemption", 1994, categoryRepository.findByName("Draama").get(0)));
            movieRepository.save(new Movie("The Godfather", 1972, categoryRepository.findByName("Draama").get(0)));
            movieRepository.save(new Movie("The Godfather: Part II", 1974, categoryRepository.findByName("Draama").get(0)));
            movieRepository.save(new Movie("The Dark Knight", 2008, categoryRepository.findByName("Draama").get(0)));
            movieRepository.save(new Movie("12 Angry Men", 1957, categoryRepository.findByName("Draama").get(0)));
            movieRepository.save(new Movie("Schindler's List", 1993, categoryRepository.findByName("Draama").get(0)));
            movieRepository.save(new Movie("Pulp Fiction", 1994, categoryRepository.findByName("Draama").get(0)));
            movieRepository.save(new Movie("The Lord of the Rings: The Return of the King", 2003, categoryRepository.findByName("Draama").get(0)));




            log.info("fetch all categorys");
            for (Category category : categoryRepository.findAll()) {
                log.info(category.toString());
            }
            log.info("-------------------------------------movie-------------------------------------");
            for (Movie movie : movieRepository.findAll()) {
                log.info(movie.toString());
            }

        };
    }

}
