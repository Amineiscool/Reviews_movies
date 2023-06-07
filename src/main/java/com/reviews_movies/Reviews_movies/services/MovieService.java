package com.reviews_movies.Reviews_movies.services;// MovieService.java

import com.reviews_movies.Reviews_movies.models.Movie;
import com.reviews_movies.Reviews_movies.repos.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movie) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie existingMovie = optionalMovie.get();
            existingMovie.setTitle(movie.getTitle());
            return movieRepository.save(existingMovie);
        }
        return null;
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }


    public boolean deleteMovie(Long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            movieRepository.delete(optionalMovie.get());
            return true;
        }
        return false;
    }
}
