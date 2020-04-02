package com.elokuvatietokanta.ektk.repository;

import com.elokuvatietokanta.ektk.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
