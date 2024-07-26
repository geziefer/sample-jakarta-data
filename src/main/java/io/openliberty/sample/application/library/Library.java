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

    List<Book> findBookByPublishYear(int year);

    List<Book> findBookByPublishYearBetween(int start, int end);

    List<Book> findBookByTitleStartsWith(String part);

    List<Book> findFirst3Book();

    List<Book> findByTitleContains(String part);

    List<Book> findByPublishYearNotLessThan(int year);

    @Delete
    void deleteAll();
}
