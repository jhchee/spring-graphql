package github.jhchee.springgraphql.config;

import github.jhchee.springgraphql.directives.UpperCaseDirectiveWiring;
import github.jhchee.springgraphql.repositories.PostRepository;
import github.jhchee.springgraphql.scalars.Scalars;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.TypeRuntimeWiring;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.query.QuerydslDataFetcher;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostsRuntimeWiring implements RuntimeWiringConfigurer {
    private final PostRepository repository;

    @Override
    public void configure(RuntimeWiring.Builder builder) {
        builder
                .type(TypeRuntimeWiring.newTypeWiring("Query")
                                       .dataFetcher("postById",
                                               QuerydslDataFetcher.builder(repository)
                                                                  .single()
                                       )
                                       .dataFetcher("recentPosts",
                                               QuerydslDataFetcher.builder(repository)
                                                                  .many()
                                       )
                )
                .scalar(Scalars.uuidType())
                .scalar(Scalars.localDateTimeType())
                .scalar(Scalars.instantType())
                .directive("uppercase", new UpperCaseDirectiveWiring())
                .build();
    }
}
