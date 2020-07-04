package com.apirest.spark.movies.repository;

import com.apirest.spark.movies.model.Movie;

import java.util.List;

public interface IMoviesRepository {
    Movie addMovie(final Movie movie);

    void deleteMovie(final Long id);

    Movie updateMovie(final Movie movie);

    Movie getMovie(final Long id);

    List<Movie> getMovies();
}
