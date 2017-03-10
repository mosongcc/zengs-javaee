package com.zengs.graphql;

/**
 * Created by song on 2017/3/9.
 */
public class Main {

    public static void main(String[] args) {

        GraphQLObjectType queryType = newObject()
                .name("helloWorldQuery")
                .field(field -> field.type(GraphQLString)
                        .name("hello")
                        .argument(argument -> argument.name("arg")
                                .type(GraphQLBoolean))
                        .dataFetcher(env -> "hello"))
                .build();

    }

}
