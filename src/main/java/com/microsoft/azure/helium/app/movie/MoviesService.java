package com.microsoft.azure.helium.app.movie;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * MoviesService
 */
@Service
public class MoviesService {

    @Autowired
    private MoviesRepository repository;

    public List<Movie> getAllMovies(Optional<String> query) {
        if (query.isPresent() && !StringUtils.isEmpty(query.get())) {
            return repository.findByTextSearchContaining(query.get().toLowerCase());
        } else {
            return (List<Movie>) repository.findAll();
        }
    }

    public Optional<Movie> getMovie(String movieId) {
        if (StringUtils.isEmpty(movieId)) {
            throw new NullPointerException("movieId cannot be empty or null");
        }

        List<Movie> movies = repository.findByMovieId(movieId);
        if (movies.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(movies.get(0));
        }
    }

}