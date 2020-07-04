package com.apirest.spark.movies.transformer;

import com.fasterxml.jackson.databind.ObjectMapper;
import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {


    @Override
    public String render(Object model) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(model);
    }
}
