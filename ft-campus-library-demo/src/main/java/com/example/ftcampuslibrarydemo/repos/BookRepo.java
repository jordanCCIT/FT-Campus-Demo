package com.example.ftcampuslibrarydemo.repos;

import com.example.ftcampuslibrarydemo.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {
}
