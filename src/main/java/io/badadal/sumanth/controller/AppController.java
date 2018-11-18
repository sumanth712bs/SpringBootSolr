package io.badadal.sumanth.controller;

import io.badadal.sumanth.model.Book;
import io.badadal.sumanth.model.Category;
import io.badadal.sumanth.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

/**
 * @author sbadadal
 */

@RestController
@RequestMapping("/solrapp")
public class AppController {

    @Autowired
    private BookRepository repository;

    @PostMapping("/bookpost")
    public ResponseEntity<?> addBook(){
        repository.save(new Book(UUID.randomUUID().toString(), "Clean Code", "Best coding practises",
                Stream.of(Category.EDUCATION, Category.TECHNOLOGY).collect(
                        Collectors.toList())));

        repository.save(new Book(UUID.randomUUID().toString(), "P.S. I Love You", "Best Love Story",
                Stream.of(Category.ROMANCE).collect(Collectors.toList())));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/book")
    public ResponseEntity<List<Book>> getAllBooks(){

    List<Book> books =   new ArrayList<>();
    repository.findAll().forEach(books :: add);
    return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostConstruct
    public void addAllBooks(){
        repository.save(new Book(UUID.randomUUID().toString(), "Clean Code", "Best coding practises",
                Stream.of(Category.EDUCATION, Category.TECHNOLOGY).collect(
                        Collectors.toList())));

        repository.save(new Book(UUID.randomUUID().toString(), "P.S. I Love You", "Best Love Story",
                Stream.of(Category.ROMANCE).collect(Collectors.toList())));

        repository.save(new Book(UUID.randomUUID().toString(), "Effective Java", "How to write clean code",
                Stream.of(Category.TECHNOLOGY).collect(
                        Collectors.toList())));

        repository.save(new Book(UUID.randomUUID().toString(), "A Dummy Technology Love Story", "Dummy book",
                Stream.of(Category.TECHNOLOGY,
                        Category.ROMANCE).collect(Collectors.toList())));
    }
}
