package github.jhchee.springgraphql.scalars;


import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;

import java.time.Instant;


public class InstantScalar implements Coercing<Instant, String> {
    @Override
    public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
        if (dataFetcherResult instanceof Instant) {
            return dataFetcherResult.toString();
        } else {
            throw new CoercingSerializeException("Not a valid Instant");
        }
    }

    @Override
    public Instant parseValue(Object input) throws CoercingParseValueException {
        return Instant.parse(input.toString());
    }

    @Override
    public Instant parseLiteral(Object input) throws CoercingParseLiteralException {
        if (input instanceof StringValue) {
            return Instant.parse(((StringValue) input).getValue());
        }

        throw new CoercingParseLiteralException("Value is not a valid ISO date time");
    }
}