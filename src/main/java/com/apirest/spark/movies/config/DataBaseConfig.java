package com.apirest.spark.movies.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {

    @Bean
    public DataSource datasource(){
        EmbeddedDatabaseBuilder builder  = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL)
                .setName("movies")
                .addScript("ddl.sql")
                .addScript("dml.sql").build();
        return db;
    }
}
