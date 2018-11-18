package io.badadal.sumanth;

import io.badadal.sumanth.model.Book;
import io.badadal.sumanth.model.Category;
import io.badadal.sumanth.repository.BookRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SolrDemoApplication {

    @Autowired
    private BookRepository repository;

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
   /* @Override
    public void run(String... args) throws Exception {
        this.repository.deleteAll();

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


        // fetch all
        System.out.println("Books found by findAll():");
        System.out.println("----------------------------");

        this.repository.findAll().forEach(product -> System.out.println(product));
    }*/



    public static void main(String[] args) {
        SpringApplication.run(SolrDemoApplication.class, args);
    }
}
