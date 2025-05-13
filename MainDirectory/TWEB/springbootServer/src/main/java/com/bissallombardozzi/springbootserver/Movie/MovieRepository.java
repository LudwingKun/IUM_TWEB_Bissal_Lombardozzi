package com.bissallombardozzi.springbootserver.Movie;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m WHERE m.filmRating IS NOT NULL ORDER BY m.filmRating DESC")
    List<Movie> findTop5ByOrderByRatingDesc();

    @Query("""
        SELECT m FROM Movie m
        LEFT JOIN m.genres g
        WHERE
        (:title IS NULL OR m.filmName LIKE %:title%) AND
        (:genre IS NULL OR g.genre LIKE %:genre%) AND
        (:year IS NULL OR FUNCTION('YEAR', m.filmDate) = :year) AND
        (:rating IS NULL OR m.filmRating >= :rating)
        ORDER BY
        CASE WHEN :sort = 'asc' THEN m.filmName END ASC,
        CASE WHEN :sort = 'desc' THEN m.filmName END DESC
""")
    List<Movie> findMoviesByFilters(
            @Param("title") String title,
            @Param("genre") String genre,
            @Param("year") Integer year,
            @Param("rating") Double rating,
            @Param("sort") String sort
    );


}