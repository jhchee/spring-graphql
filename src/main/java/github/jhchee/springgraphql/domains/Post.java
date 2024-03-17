package github.jhchee.springgraphql.domains;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Post {
    @Id
    private ObjectId _id = new ObjectId();

    @Indexed(unique = true)
    private String id;
    private String title;
    private String authorId;
}
