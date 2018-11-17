package io.badadal.sumanth;

import io.badadal.sumanth.model.Book;
import io.badadal.sumanth.model.Category;
import io.badadal.sumanth.repository.BookRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SolrDemoApplication {

    @Autowired
    private BookRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SolrDemoApplication.class, args);
    }


    public InitializingBean initialData() {

        return () -> {
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
        };
    }
}
