package github.jhchee.springgraphql.domains;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document
@Builder
public class Post {
    @Id
    @Builder.Default
    private ObjectId _id = new ObjectId();

    @Indexed(unique = true)
    private String id;
    private String title;
    private String text;
    private String authorId;
    private Instant createdAt;
}
