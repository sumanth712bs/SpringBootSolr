package io.badadal.sumanth.service;

import io.badadal.sumanth.model.Book;
import io.badadal.sumanth.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author sbadadal
 */

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> findAllBooks() {
        List<Book> books = new ArrayList<>();
        repository.findAll().forEach(books::add);
        return books;
    }

    @Override
    public Optional<Book> findBookByName(String bookName) {
        Book book = repository.findBookByName(bookName);
        return Optional.of(book);
    }

    @Override
    public void addNewBook(Book book) {
        if (null != book) {
            repository.save(book);
        }
    }

    @Override
    public void deleteBookByName(String bookName) {

        Book book = findBookByName(bookName).get();

        repository.delete(book);
    }

    @Override
    public void deleteAllBooks() {

        repository.deleteAll();

    }
}
