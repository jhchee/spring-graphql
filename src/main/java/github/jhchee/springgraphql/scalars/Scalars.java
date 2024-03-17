package github.jhchee.springgraphql.scalars;

import graphql.schema.GraphQLScalarType;

public class Scalars {

    public static GraphQLScalarType uuidType() {
        return GraphQLScalarType.newScalar()
                .name("UUID")
                .description("UUID type")
                .coercing(new UUIDScalar())
                .build();
    }

    public static GraphQLScalarType localDateTimeType() {
        return GraphQLScalarType.newScalar()
                .name("LocalDateTime")
                .description("LocalDateTime type")
                .coercing(new LocalDateTimeScalar())
                .build();
    }

    public static GraphQLScalarType instantType() {
        return GraphQLScalarType.newScalar()
                                .name("Instant")
                                .description("Instant type")
                                .coercing(new InstantScalar())
                                .build();
    }
}