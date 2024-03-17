package github.jhchee.springgraphql.config;

import github.jhchee.springgraphql.directives.UpperCaseDirectiveWiring;
import github.jhchee.springgraphql.repositories.PostRepository;
import graphql.schema.idl.RuntimeWiring;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostsRuntimeWiring implements RuntimeWiringConfigurer {
    private final PostRepository repository;

    @Override
    public void configure(RuntimeWiring.Builder builder) {
        builder
//                .type(TypeRuntimeWiring.newTypeWiring("Query")
//                                       .dataFetcher("posts",
//                                               QuerydslDataFetcher.builder(repository)
//                                                       .quer
//                                       )
//                                       .many())
.directive("uppercase", new UpperCaseDirectiveWiring())
.build();
    }
}
