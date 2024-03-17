package github.jhchee.springgraphql;

import github.jhchee.springgraphql.domains.Post;
import github.jhchee.springgraphql.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements ApplicationRunner {
    private final PostRepository postRepository;

    @Override

    public void run(ApplicationArguments args) throws Exception {
        log.info("start data initialization...");
        postRepository.deleteAll();
        List<Post> posts = IntStream.range(1, 100)
                                    .mapToObj(
                                            i -> Post.builder()
                                                     .id(Integer.toString(i))
                                                     .title("Post #" + i)
                                                     .text("Content #" + i)
                                                     .authorId("Author #" + i)
                                                     .createdAt(Instant.now())
                                                     .build()

                                    )
                                    .toList();

        postRepository.saveAll(posts);
        postRepository.findAll().forEach(p -> log.info("post: {}", p));
        log.info("done data initialization...");
    }
}