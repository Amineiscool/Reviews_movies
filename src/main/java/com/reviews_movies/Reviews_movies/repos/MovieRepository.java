package com.reviews_movies.Reviews_movies.repos;// MovieRepository.java

import com.reviews_movies.Reviews_movies.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
