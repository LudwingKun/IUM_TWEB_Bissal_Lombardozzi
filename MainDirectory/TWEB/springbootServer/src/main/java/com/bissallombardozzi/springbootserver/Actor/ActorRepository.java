package com.bissallombardozzi.springbootserver.Actor;

import jakarta.persistence.*;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query("SELECT a FROM Actor a WHERE a.actorName = :name")
    List<Actor> findByActorName(@Param("name") String name);

    @Query("SELECT a FROM Actor a WHERE a.actorName LIKE %:name%")
    List<Actor> findByActorNameContaining(@Param("name") String name);
}