package github.jhchee.springgraphql.repositories;

import github.jhchee.springgraphql.domains.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorRepository {
    private static final List<Author> authors;

    static {
        authors = new ArrayList<>();
        for (int authorId = 0; authorId < 10; ++authorId) {
            Author author = new Author();
            author.setId("Author" + authorId);
            author.setName("Author " + authorId);
            authors.add(author);
        }
    }

    public Author getAuthor(String id) {
        return authors.stream()
                      .filter(author -> id.equals(author.getId()))
                      .findFirst()
                      .orElseThrow(RuntimeException::new);
    }
}
