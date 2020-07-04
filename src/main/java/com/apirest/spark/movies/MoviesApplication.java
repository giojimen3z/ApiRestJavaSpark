package com.apirest.spark.movies;

import com.apirest.spark.movies.model.Movie;
import com.apirest.spark.movies.service.IMoviesService;
import com.apirest.spark.movies.transformer.JsonTransformer;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static spark.Spark.*;

public class MoviesApplication {
    private static final String ID_PARAMETER = "id";
    private IMoviesService iMoviesService;

    public MoviesApplication(final IMoviesService iMoviesService) {
        this.iMoviesService = iMoviesService;
        initializeRoutes();
    }
    private void initializeRoutes() {

      port(8080);

      get("/movies", (request, response) -> {
            return iMoviesService.getMovies();
        }, new JsonTransformer());

      get ("/movie/:id", (request, response) -> {
          final String id = request.params(ID_PARAMETER);
          return  iMoviesService.getMovie(Long.valueOf(id));
      }, new  JsonTransformer());
        post("/movie", (req, res) -> {
            final Movie movie = readBody(req.body());
            return iMoviesService.addMovie(movie);
        }, new JsonTransformer());

        delete("/movie/delete/:id", (req, res) -> {
            final String id = req.params(ID_PARAMETER);
            iMoviesService.deleteMovie(Long.valueOf(id));
            return "";
        });

        put("/movie/update/:id", (req, res) -> {
            final Movie movie = readBody(req.body());
            return iMoviesService.updateMovie(movie);
        }, new JsonTransformer());
    }
    private Movie readBody(final String jsonData) throws JsonParseException, JsonMappingException, IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonData, Movie.class);
    }
}
