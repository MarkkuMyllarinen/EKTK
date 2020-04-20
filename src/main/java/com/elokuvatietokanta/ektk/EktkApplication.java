package com.elokuvatietokanta.ektk;

import com.elokuvatietokanta.ektk.model.Category;
import com.elokuvatietokanta.ektk.model.Movie;
import com.elokuvatietokanta.ektk.model.Rating;
import com.elokuvatietokanta.ektk.model.User;
import com.elokuvatietokanta.ektk.repository.CategoryRepository;
import com.elokuvatietokanta.ektk.repository.MovieRepository;
import com.elokuvatietokanta.ektk.repository.RatingRepository;
import com.elokuvatietokanta.ektk.repository.UserRepository;
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


}
