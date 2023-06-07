package com.reviews_movies.Reviews_movies.repos;

import com.reviews_movies.Reviews_movies.models.Movie;
import com.reviews_movies.Reviews_movies.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
