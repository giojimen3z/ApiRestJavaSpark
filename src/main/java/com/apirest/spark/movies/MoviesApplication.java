package com.apirest.spark.movies;

import com.apirest.spark.movies.service.IMoviesService;
import com.apirest.spark.movies.transformer.JsonTransformer;

import static spark.Spark.port;
import static spark.Spark.get;

public class MoviesApplication {
    private static final String ID_PARAMETER = "id";
    private IMoviesService iMoviesService;

    public MoviesApplication(final IMoviesService iMoviesService) {
        this.iMoviesService = iMoviesService;
        initializeRoutes();
    }
    private void initializeRoutes() {

      port(8080);

      get("/movie", (request, response) -> {
            return iMoviesService.getMovies();
        }, new JsonTransformer());

      get ("/movies/:id", (request, response) -> {
          final String id = request.params(ID_PARAMETER);
          return  iMoviesService.getMovie(Long.valueOf(id));
      }, new  JsonTransformer());
    }
}
