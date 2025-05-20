package com.bissallombardozzi.springbootserver.Actor;

import com.bissallombardozzi.springbootserver.Movie.Movie;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unique", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private Movie movie;

    @Column(name = "name", nullable = false)
    private String actorName;

    @Column(name = "role", nullable = false)
    private String actorRole;

    public Actor() {}

    public Actor(Movie movie, String actorName, String actorRole) {
        this.movie = movie;
        this.actorName = actorName;
        this.actorRole = actorRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorRole() {
        return actorRole;
    }

    public void setActorRole(String actorRole) {
        this.actorRole = actorRole;
    }
}
