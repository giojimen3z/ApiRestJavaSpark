package com.apirest.spark.movies.service;

import com.apirest.spark.movies.model.Movie;
import com.apirest.spark.movies.repository.IMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServicesImpl implements IMoviesService {
    @Autowired
    private IMoviesRepository iMoviesRepository;

    public Movie addMovie(Movie movie) {
        return iMoviesRepository.addMovie(movie);
    }

    public void deleteMovie(Long id) {
        iMoviesRepository.deleteMovie(id);
    }

    public Movie updateMovie(Movie movie) {
        return iMoviesRepository.updateMovie(movie);
    }

    public Movie getMovie(Long id) {
        return iMoviesRepository.getMovie(id);
    }

    public List<Movie> getMovies() {
        return iMoviesRepository.getMovies();
    }
}
