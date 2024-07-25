package io.openliberty.sample.application.library;

import jakarta.data.repository.*;
import jakarta.validation.Valid;

import java.util.List;

@Repository
public interface Library extends DataRepository<Book, String> {
    @Insert
    Book store(@Valid Book book);

    @Find
    @OrderBy("publishYear")
    List<Book> searchAllBooks();

    @Delete
    void deleteAll();
}
