package com.example.ftcampuslibrarydemo.models;

import net.bytebuddy.build.Plugin;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Campus campus;
    private String title;
    @Lob
    private String summary;
    private boolean available;
    @ManyToMany
    private Collection<Author> authors;

    public Book(Campus campus, String title, String summary, boolean available, Author...authors) {
        this.campus = campus;
        this.title = title;
        this.summary = summary;
        this.available = available;
        this.authors = Set.of(authors);
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public Campus getCampus() {
        return campus;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public boolean isAvailable() {
        return available;
    }

    public Collection<Author> getAuthors() {
        return authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return available == book.available && Objects.equals(id, book.id) && Objects.equals(campus, book.campus) && Objects.equals(title, book.title) && Objects.equals(summary, book.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, campus, title, summary, available);
    }
}