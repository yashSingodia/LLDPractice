package TicketBookingSystem.service;

import TicketBookingSystem.model.Movie;
import TicketBookingSystem.util.Utils;

import java.util.HashMap;
import java.util.Map;

public class MovieService {
    private final Map<String, Movie> movies;

    public MovieService() {
        this.movies = new HashMap<>();
    }

    public Movie getMovie( final String movieId) {
        if (!movies.containsKey(movieId)) {
            throw new RuntimeException();
        }
        return movies.get(movieId);
    }

    public Movie createMovie(final String movieName) {
        String movieId = Utils.getRandomUUID();
        Movie movie = new Movie(movieId, movieName);
        movies.put(movieId, movie);
        return movie;
    }
}
