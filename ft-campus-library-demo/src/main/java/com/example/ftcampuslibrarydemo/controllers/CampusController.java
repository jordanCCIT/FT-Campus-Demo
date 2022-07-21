package com.example.ftcampuslibrarydemo.controllers;

import com.example.ftcampuslibrarydemo.models.Book;
import com.example.ftcampuslibrarydemo.models.Campus;
import com.example.ftcampuslibrarydemo.repos.BookRepo;
import com.example.ftcampuslibrarydemo.repos.CampusRepo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RestController
public class CampusController {
    private CampusRepo campusRepo;
    private BookRepo bookRepo;

    public CampusController(CampusRepo campusRepo, BookRepo bookRepo) {
        this.campusRepo = campusRepo;
        this.bookRepo = bookRepo;
    }

    @GetMapping("/api/campuses")
    public Iterable<Campus> retrieveAllCampuses(){
        return campusRepo.findAll();
    }

    @GetMapping("/api/campuses/{id}")
    public Campus retrieveCampusById(@PathVariable Long id){
        return campusRepo.findById(id).get();
    }

    @PostMapping("/api/campuses/{id}/addBook")
    public Campus addBookToCampus(@PathVariable Long id,@RequestBody Book book){
        Campus campus = campusRepo.findById(id).get();
        book.setCampus(campus);
        bookRepo.save(book);
        return campus;
    }

    @PostMapping("/api/campuses")
    public Iterable<Campus> addCampus(@RequestBody Campus campusToAdd){
        campusRepo.save(campusToAdd);
        return campusRepo.findAll();
    }
    
    @PatchMapping("/api/campuses/{id}/location")
    public Campus campusToChangeLocation(@RequestBody String newLocation,@PathVariable Long id){
        Campus campusToChange = campusRepo.findById(id).get();
        campusToChange.changeLocation(newLocation);
        campusRepo.save(campusToChange);
        return campusToChange;
    }
}
