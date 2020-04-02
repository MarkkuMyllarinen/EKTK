package com.elokuvatietokanta.ektk.repository;

import com.elokuvatietokanta.ektk.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
