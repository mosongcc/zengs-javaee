package com.zingson.graphql;

import java.util.List;
import java.util.Map;

/**
 *
 */
public class Field {

    String name;

    Object value;

    String description;

    Class type;

    Map<String,Object> params;

    List<Field> fields;

}
