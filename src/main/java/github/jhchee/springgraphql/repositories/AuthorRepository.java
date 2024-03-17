package github.jhchee.springgraphql.repositories;

import github.jhchee.springgraphql.domains.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String>, QuerydslPredicateExecutor<Author> {
//    private static final List<Author> authors;
//
//    static {
//        authors = new ArrayList<>();
//        for (int authorId = 0; authorId < 10; ++authorId) {
//            Author author = new Author();
//            author.setId("Author" + authorId);
//            author.setName("Author " + authorId);
//            authors.add(author);
//        }
//    }
//
//    public Author getAuthor(String id) {
//        return authors.stream()
//                      .filter(author -> id.equals(author.getId()))
//                      .findFirst()
//                      .orElseThrow(RuntimeException::new);
//    }
}
