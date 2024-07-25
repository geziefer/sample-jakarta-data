package io.openliberty.sample.application.library;

import jakarta.persistence.Embeddable;

// A record should have used here, but persistence-3.2 is not yet available, which demonstrate embeddable records
@Embeddable
public class Author {
    private String name;
    private int yearOfBirth;
    private Country nationality;

    public Author() {
    }

    public Author(String name, int yearOfBirth, Country nationality) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public Country getNationality() {
        return nationality;
    }
}
