package com.elokuvatietokanta.ektk.repository;

import com.elokuvatietokanta.ektk.model.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Long> {
}
