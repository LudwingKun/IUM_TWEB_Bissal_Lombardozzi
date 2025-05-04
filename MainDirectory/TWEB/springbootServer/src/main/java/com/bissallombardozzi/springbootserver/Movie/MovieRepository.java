package com.bissallombardozzi.springbootserver.Movie;

import jakarta.persistence.*;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m WHERE m.filmRating IS NOT NULL ORDER BY m.filmRating DESC")
    List<Movie> findTop5ByOrderByRatingDesc();
}