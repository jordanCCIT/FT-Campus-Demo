package com.example.ftcampuslibrarydemo.repos;

import com.example.ftcampuslibrarydemo.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Long> {
}
