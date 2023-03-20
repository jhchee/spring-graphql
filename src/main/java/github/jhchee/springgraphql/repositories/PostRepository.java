package github.jhchee.springgraphql.repositories;

import github.jhchee.springgraphql.domains.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PostRepository {
    private final static List<Post> posts;

    static {
        posts = new ArrayList<>();
        for (int postId = 0; postId < 10; ++postId) {
            for (int authorId = 0; authorId < 10; ++authorId) {
                Post post = new Post();
                post.setId("Post" + authorId + postId);
                post.setTitle("Post " + authorId + ":" + postId);
                post.setAuthorId("Author" + authorId);
                posts.add(post);
            }
        }
    }


    public List<Post> getRecentPosts(int count, int offset) {
        return posts.stream()
                    .skip(offset)
                    .limit(count)
                    .collect(Collectors.toList());
    }

    public List<Post> getAuthorPosts(String author) {
        return posts.stream()
                    .filter(post -> author.equals(post.getAuthorId()))
                    .collect(Collectors.toList());
    }

    public void savePost(Post post) {
        posts.add(post);
    }
}
