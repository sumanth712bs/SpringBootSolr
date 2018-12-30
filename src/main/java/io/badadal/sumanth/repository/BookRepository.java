package io.badadal.sumanth.repository;

import io.badadal.sumanth.model.Book;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sbadadal
 */
@Repository
public interface BookRepository extends SolrCrudRepository<Book, String> {

    Book findBookByName(String bookName);
}
