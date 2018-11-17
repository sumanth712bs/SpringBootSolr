package io.badadal.sumanth.repository;

import io.badadal.sumanth.model.Book;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * @author sbadadal
 */
public interface BookRepository extends SolrCrudRepository<Book, String> {
}
