package com.example.ftcampuslibrarydemo.controllers;

import com.example.ftcampuslibrarydemo.models.Book;
import com.example.ftcampuslibrarydemo.models.Campus;
import com.example.ftcampuslibrarydemo.repos.BookRepo;
import com.example.ftcampuslibrarydemo.repos.CampusRepo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

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

    @PostMapping("/api/campuses")
    public Iterable<Campus> addCampus(@RequestBody Campus campusToAdd){
        campusRepo.save(campusToAdd);
        return campusRepo.findAll();
    }

//    @PutMapping("/api/campuses")
//    public Iterable<Campus> editCampus(@RequestBody Campus campusToEdit){
//        if(campusToEdit.getId()!=null){
//            Campus campusToChange = campusRepo.findById(campusToEdit.getId()).get();
//            ArrayList<Book> books = (ArrayList)campusToChange.getBooks();
//            campusRepo.save(campusToEdit);
//            for (int i = 0; i < books.size();i++){
//                books.get(i).ChangeCampus(campusToEdit);
//                bookRepo.save( books.get(i));
//            }
//        }
//        return campusRepo.findAll();
//    }

    @PatchMapping("/api/campuses/{id}/location")
    public Campus campusToChangeLocation(@RequestBody String newLocation,@PathVariable Long id){
        Campus campusToChange = campusRepo.findById(id).get();
        campusToChange.changeLocation(newLocation);
        campusRepo.save(campusToChange);
        return campusToChange;
    }
}
