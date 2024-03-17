package github.jhchee.springgraphql.repositories;

import github.jhchee.springgraphql.domains.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String>, QuerydslPredicateExecutor<Post> {
}
