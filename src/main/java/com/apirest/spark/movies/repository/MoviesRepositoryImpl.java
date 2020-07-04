package com.apirest.spark.movies.repository;

import com.apirest.spark.movies.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MoviesRepositoryImpl implements IMoviesRepository {

    private static final String SYNOPSIS = "synopsis";
    private static final String DIRECTOR = "director";
    private static final String TITLE = "title";
    private static final String YEAR = "year";
    private static final String ID = "id";

    private JdbcTemplate template;

    @Autowired
    public  MoviesRepositoryImpl(DataSource ds) {

        template = new JdbcTemplate(ds);

    }


    public Movie addMovie(Movie movie) {
        final String query = "insert into movie(id, title, director, year, synopsis) values(:id, :title, :director, :year, :synopsis)";
        final Map params =  new HashMap();
        params.put(ID,movie.getId());
        params.put(TITLE, movie.getTitle());
        params.put(DIRECTOR, movie.getDirector());
        params.put(YEAR, movie.getYear());
        params.put(SYNOPSIS, movie.getSynopsis());
        template.update(query, params);
        return movie;
    }


    public void deleteMovie(Long id) {
        final String query = "delete from movie where id = :id";
        final Map params = new HashMap();
        params.put(ID, id);


    }

    public Movie updateMovie(Movie movie) {
        final String query = "update movie set title = :title, director = :director, year = :year, synopsis = :synopsis where id = :id";
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put(ID, movie.getId());
        params.put(TITLE, movie.getTitle());
        params.put(DIRECTOR, movie.getDirector());
        params.put(YEAR, movie.getYear());
        params.put(SYNOPSIS, movie.getSynopsis());
        template.update(query, params);
        return movie;
    }

    public Movie getMovie(Long id) {
        final String query = "select id, title, director, year, synopsis from movie where id = :id";


        return template.queryForObject(query, new Object[]{id}, buildRowMapper());
    }

    public List<Movie> getMovies() {
        final String query = "select id, title, director, year, synopsis from movie";

        return template.query(query, buildRowMapper());
    }

    private RowMapper<Movie> buildRowMapper() {

        final RowMapper<Movie> rowMapper = (rs, rowNum) -> {
            final Movie movie = new Movie();
            movie.setId(rs.getLong(ID));
            movie.setTitle(rs.getString(TITLE));
            movie.setDirector(rs.getString(DIRECTOR));
            movie.setYear(rs.getLong(YEAR));
            movie.setSynopsis(rs.getString(SYNOPSIS));
            return movie;
        };

        return rowMapper;

    }
}
