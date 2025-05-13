package com.bissallombardozzi.springbootserver.Dto;


public class ActorDetails {
    private String name;
    private String role;
    private MovieDetails movie;

    public ActorDetails() {
    }

    public ActorDetails(String name, String role, MovieDetails movie) {
        this.name = name;
        this.role = role;
        this.movie = movie;
    }

    public ActorDetails(String actorName, String actorRole) {
        this.name = actorName;
        this.role = actorRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public MovieDetails getMovie() {
        return movie;
    }

    public void setMovie(MovieDetails movie) {
        this.movie = movie;
    }

}
