package io.badadal.sumanth.service;

import io.badadal.sumanth.model.Book;

import java.util.List;
import java.util.Optional;

/**
 * @author sbadadal
 */

public interface BookService {

    List<Book> findAllBooks();

    Optional<Book> findBookByName(String bookName);

    void addNewBook(Book book);

    void deleteBookByName(String bookName);

    void deleteAllBooks();
}
