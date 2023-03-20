package github.jhchee.springgraphql.domains;

import lombok.Data;

@Data
public class Post {
    private String id;
    private String title;
    private String authorId;
}
