package github.jhchee.springgraphql.controllers;

import github.jhchee.springgraphql.domains.Author;
import github.jhchee.springgraphql.domains.Post;
import github.jhchee.springgraphql.repositories.AuthorRepository;
import github.jhchee.springgraphql.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;

//    @QueryMapping
//    public List<Post> recentPosts(@Argument int count, @Argument int offset) {
//        return postRepository.getRecentPosts(count, offset);
//    }
//
//    @QueryMapping
//    public String helloWorld() {
//        return "Hello, World!";
//    }
//
//    @SchemaMapping
//    public Author author(Post post) {
//        return authorRepository.getAuthor(post.getAuthorId());
//    }
//
//    @SchemaMapping(typeName = "Post", field = "first_author")
//    public Author getFirstAuthor(Post post) {
//        return authorRepository.getAuthor(post.getAuthorId());
//    }
//
//    @MutationMapping
//    public Post createPost(@Argument String title, @Argument String text,
//                           @Argument String category, @Argument String authorId) {
//        Post post = new Post();
//        post.setId(UUID.randomUUID().toString());
//        post.setTitle(title);
//        post.setAuthorId(authorId);
//        postRepository.savePost(post);
//        return post;
//    }


}