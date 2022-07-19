package com.example.ftcampuslibrarydemo.repos;

import com.example.ftcampuslibrarydemo.models.Campus;
import org.springframework.data.repository.CrudRepository;

public interface CampusRepo extends CrudRepository<Campus, Long> {
}
