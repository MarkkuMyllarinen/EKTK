package com.elokuvatietokanta.ektk;

import com.elokuvatietokanta.ektk.model.Category;
import com.elokuvatietokanta.ektk.model.Movie;
import com.elokuvatietokanta.ektk.repository.CategoryRepository;
import com.elokuvatietokanta.ektk.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class EktkApplication {

	private static final Logger log = LoggerFactory.getLogger(EktkApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EktkApplication.class, args);
	}


	@Bean
	public CommandLineRunner ektkDemo(CategoryRepository categoryRepository, MovieRepository movieRepository){
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


			movieRepository.save(new Movie(" Rita Hayworth - avain pakoon", 1994,9.2f, categoryRepository.findByName("Draama").get(0)));
			movieRepository.save(new Movie(" Rita Hayworth - avain pakoon", 1994,9.2f, categoryRepository.findByName("Draama").get(0)));
			movieRepository.save(new Movie(" Rita Hayworth - avain pakoon", 1994,9.2f, categoryRepository.findByName("Draama").get(0)));
			movieRepository.save(new Movie(" Rita Hayworth - avain pakoon", 1994,9.2f, categoryRepository.findByName("Draama").get(0)));
			movieRepository.save(new Movie(" Rita Hayworth - avain pakoon", 1994,9.2f, categoryRepository.findByName("Draama").get(0)));

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
