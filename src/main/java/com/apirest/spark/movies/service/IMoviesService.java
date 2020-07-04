package com.apirest.spark.movies.service;

import com.apirest.spark.movies.model.Movie;

import java.util.List;

public interface IMoviesService {

    Movie addMovie(final Movie movie);

    void deleteMovie(final Long id);

    Movie updateMovie(final Movie movie);

    Movie getMovie(final Long id);

    List<Movie> getMovies();


}
