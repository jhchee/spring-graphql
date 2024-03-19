package github.jhchee.springgraphql.directives;

import graphql.Scalars;
import graphql.schema.*;
import graphql.schema.idl.SchemaDirectiveWiring;
import graphql.schema.idl.SchemaDirectiveWiringEnvironment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EvaluationWiring implements SchemaDirectiveWiring {
    @Override
    public GraphQLFieldDefinition onField(SchemaDirectiveWiringEnvironment<GraphQLFieldDefinition> env) {
        GraphQLFieldDefinition field = env.getElement();
        GraphQLFieldsContainer parentType = env.getFieldsContainer();

        var dataFetcher = DataFetcherFactories.wrapDataFetcher(env.getFieldDataFetcher(), ((dataFetchingEnvironment, value) -> {
            DateTimeFormatter dateTimeFormatter = buildFormatter(dataFetchingEnvironment.getArgument("format"));
            if (value instanceof LocalDateTime) {
                return dateTimeFormatter.format((LocalDateTime) value);
            }
            return value;
        }));

        //
        // This will extend the field by adding a new "format" argument to it for the date formatting
        // which allows clients to opt into that as well as wrapping the base data fetcher so it
        // performs the formatting over top of the base values.
        //
        FieldCoordinates coordinates = FieldCoordinates.coordinates(parentType, field);
        env.getCodeRegistry().dataFetcher(coordinates, dataFetcher);

        return field.transform(builder -> builder
                .argument(GraphQLArgument
                        .newArgument()
                        .name("format")
                        .type(Scalars.GraphQLString)
                        .defaultValueProgrammatic("dd-MM-YYYY")
                )
        );
    }

    private DateTimeFormatter buildFormatter(String format) {
        String dtFormat = format != null ? format : "dd-MM-YYYY";
        return DateTimeFormatter.ofPattern(dtFormat);
    }
}