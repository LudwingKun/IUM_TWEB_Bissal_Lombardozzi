package com.bissallombardozzi.springbootserver.Movie;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {


    @Query(value = "SELECT * FROM movies WHERE rating IS NOT NULL ORDER BY rating DESC LIMIT 5", nativeQuery = true)
    List<Movie> findTop5ByOrderByRatingDesc();

    @Query(value = "SELECT * FROM movies ORDER BY RANDOM() LIMIT 5", nativeQuery = true)
    List<Movie> findRandomMovies();

    @Query("SELECT m FROM Movie m JOIN m.genres g WHERE g.genre = :genre AND m.filmDate = :year ORDER BY m.id ASC")
    List<Movie> findMoviesByGenreAndYear(@Param("genre") String genre, @Param("year") int year, Pageable pageable);


    @Query("SELECT m FROM Movie m JOIN m.genres g WHERE " +
            "(:filmName IS NULL OR m.filmName LIKE %:filmName%) AND " +
            "(:year IS NULL OR m.filmDate LIKE :year) AND " +
            "(:rating IS NULL OR m.filmRating >= :rating) AND " +
            "(:genre IS NULL OR g.genre LIKE %:genre%)")
    Page<Movie> findMovies(@Param("filmName") String filmName,
                           @Param("year") String year,
                           @Param("rating") Double rating,
                           @Param("genre") String genre,
                           Pageable pageable);
}