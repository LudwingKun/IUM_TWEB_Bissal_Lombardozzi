package com.bissallombardozzi.springbootserver.MovieDetails;
 //DTO for movie
import com.bissallombardozzi.springbootserver.ActorDetails.ActorDetails;

import java.util.List;

public class MoviesDetails {
    private Long id;
    private String title;
    private String description;
    private String releaseDate;
    private List<String> genres;
    private List<String> languages;
    private String posterUrl;
    private List<ActorDetails> actors;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public List<ActorDetails> getActors() {
        return actors;
    }

    public void setActors(List<ActorDetails> actors) {
        this.actors = actors;
    }
}
