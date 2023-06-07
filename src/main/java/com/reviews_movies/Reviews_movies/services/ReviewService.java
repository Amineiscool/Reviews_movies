package com.reviews_movies.Reviews_movies.services;// ReviewService.java

import com.reviews_movies.Reviews_movies.models.Movie;
import com.reviews_movies.Reviews_movies.models.Review;
import com.reviews_movies.Reviews_movies.repos.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieService movieService;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, MovieService movieService) {
        this.reviewRepository = reviewRepository;
        this.movieService = movieService;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review createReview(Review review, Long movieId) {
        Optional<Movie> optionalMovie = Optional.ofNullable(movieService.getMovieById(movieId));
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            review.setMovie(movie);
            return reviewRepository.save(review);
        }
        return null;
    }


    public Review updateReview(Long id, Review review) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if (optionalReview.isPresent()) {
            Review existingReview = optionalReview.get();
            existingReview.setComment(review.getComment());
            return reviewRepository.save(existingReview);
        }
        return null;
    }


    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public boolean deleteReview(Long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if (optionalReview.isPresent()) {
            reviewRepository.delete(optionalReview.get());
            return true;
        }
        return false;
    }
}
