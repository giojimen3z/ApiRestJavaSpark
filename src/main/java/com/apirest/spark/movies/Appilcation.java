package com.apirest.spark.movies;

import com.apirest.spark.movies.config.DataBaseConfig;
import com.apirest.spark.movies.service.IMoviesService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.apirest.spark.movies"})
public class Appilcation {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Appilcation.class, DataBaseConfig.class);
        new MoviesApplication(ctx.getBean(IMoviesService.class));
        ctx.registerShutdownHook();

    }
}
