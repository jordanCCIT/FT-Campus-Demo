package com.example.ftcampuslibrarydemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Campus {
    @Id
    @GeneratedValue
    private Long id;
    private String location;
    private String techStack;
    @OneToMany(mappedBy = "campus")
    private Collection<Book> books;

    public Campus(String location, String techStack) {
        this.location = location;
        this.techStack = techStack;
    }

    public Campus() {
    }

    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getTechStack() {
        return techStack;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void changeLocation(String newLocation){
        location = newLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campus campus = (Campus) o;
        return Objects.equals(id, campus.id) && Objects.equals(location, campus.location) && Objects.equals(techStack, campus.techStack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, techStack);
    }
}
