package com.bissallombardozzi.springbootserver.Actor;

import com.bissallombardozzi.springbootserver.Dto.ActorDetails;
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
    WHERE a.filmId = :movieId
""")
    List<ActorDetails> findByFilmId(@Param("movieId") Long movieId);

    List<Actor> findByActorName(String name);
}