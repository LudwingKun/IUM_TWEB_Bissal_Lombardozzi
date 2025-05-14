package com.bissallombardozzi.springbootserver.Movie;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {


    @Query("SELECT m FROM Movie m WHERE m.filmRating IS NOT NULL ORDER BY m.filmRating DESC")
    List<Movie> findTop5ByOrderByRatingDesc();

/*    @Query("""
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
    );*/

    @Query("SELECT m FROM Movie m JOIN m.genres g WHERE g.genre = :genre AND m.filmDate = :year ORDER BY m.id ASC")
    List<Movie> findMoviesByGenreAndYear(@Param("genre") String genre, @Param("year") int year, Pageable pageable);


    @Query("SELECT m FROM Movie m JOIN m.genres g WHERE " +
            "(m.filmName LIKE %:filmName% OR :filmName IS NULL) AND " +
            "(m.filmDate = :year OR :year IS NULL) AND " +
            "(m.filmRating = :rating OR :rating IS NULL) AND " +
            "(g.genre LIKE %:genre% OR :genre IS NULL)")
    List<Movie> findMovies(@Param("filmName") String filmName,
                           @Param("year") Integer year,
                           @Param("rating") Double rating,
                           @Param("genre") String genre);
}