package com.bissallombardozzi.springbootserver.Actor;

import com.bissallombardozzi.springbootserver.Dto.ActorDetails;
import com.bissallombardozzi.springbootserver.Movie.Movie;
import jakarta.persistence.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    //    @Query("SELECT new com.a FROM Actor a WHERE a.actorName = :name")
//    List<ActorDetails> findByActorName(@Param("name") String name);


    @Query("SELECT a FROM Actor a WHERE a.actorName LIKE %:name%")
    List<Actor> findByActorNameContaining(@Param("name") String name);

    @Query("""
                SELECT new com.bissallombardozzi.springbootserver.Dto.ActorDetails(a.actorName, a.actorRole)
                FROM Actor a
                WHERE a.movie.id = :movieId
            """)
    List<ActorDetails> findByMovieId(@Param("movieId") Long movieId);

    @Query("SELECT a.movie FROM Actor a WHERE a.actorName = :name")
    List<Movie> findMoviesByActorName(@Param("name") String name);


    @Query("""
                SELECT a
                FROM Actor a
                JOIN FETCH a.movie m
                WHERE a.actorName = :name
           """)
    List<Actor> findByActorName(@Param("name") String name);
}