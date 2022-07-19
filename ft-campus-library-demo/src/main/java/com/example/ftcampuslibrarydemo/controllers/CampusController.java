package com.example.ftcampuslibrarydemo.controllers;

import com.example.ftcampuslibrarydemo.models.Campus;
import com.example.ftcampuslibrarydemo.repos.CampusRepo;
import org.springframework.web.bind.annotation.*;

@RestController
public class CampusController {
    private CampusRepo campusRepo;

    public CampusController(CampusRepo campusRepo) {
        this.campusRepo = campusRepo;
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

    @PutMapping("/api/campuses")
    public Iterable<Campus> editCampus(@RequestBody Campus campusToEdit){
        if(campusToEdit.getId()!=null){
            campusRepo.save(campusToEdit);
        }
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
