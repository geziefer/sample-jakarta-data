package io.openliberty.sample.application.library;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Book {
    @Id
    private String isbn;

    @NotNull
    private String title;

    @Embedded
    private Author author;

    private int publishYear;

    public Book() {}

    public Book(String isbn, String title, Author author, int publishYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public @NotNull String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }
}
