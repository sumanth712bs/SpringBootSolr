package io.badadal.sumanth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.List;

/**
 * @author sbadadal
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@SolrDocument(solrCoreName = "book")
public class Book {

    @Field
    private String id;

    @Field
    private String name;

    @Field
    private String description;

    @Field("categories_text")
    private List<Category> categories;

}
