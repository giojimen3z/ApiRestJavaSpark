package com.apirest.spark.movies.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {

    private Long id;
    private String title;
    private String director;
    private Long year;
    private String synopsis;

    public Movie() {
        super();
    }

    public Movie(final Long id, final String title, final String director, final Long year, final String synopsis) {
        super();
        this.id = id;
        this.title = title;
        this.director = director;
        this.year = year;
        this.synopsis = synopsis;
    }
}
