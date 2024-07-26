package io.openliberty.sample.application.library;

import jakarta.persistence.Embeddable;

@Embeddable
public record Author (
    String name,
    int yearOfBirth,
    Country nationality) {}
