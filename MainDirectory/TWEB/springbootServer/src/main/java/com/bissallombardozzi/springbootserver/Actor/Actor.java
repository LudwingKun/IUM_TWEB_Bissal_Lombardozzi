package com.bissallombardozzi.springbootserver.Actor;

import jakarta.persistence.*;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unique", nullable = false)
    private Long id;

    @Column(name = "id", nullable = false)
    private Long id_film;

    @Column(name = "name", nullable = false)
    private String actorName;

    @Column(name = "role", nullable = false)
    private String actorRole;

    public Actor() {
    }

    public Actor(Long id_film, String actorName, String actorRole) {
        this.id_film = id_film;
        this.actorName = actorName;
        this.actorRole = actorRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_film() {
        return id_film;
    }

    public void setId_film(Long id_film) {
        this.id_film = id_film;
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
