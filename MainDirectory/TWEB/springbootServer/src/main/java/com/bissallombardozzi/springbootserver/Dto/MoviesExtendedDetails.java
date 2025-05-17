package com.bissallombardozzi.springbootserver.Dto;

import com.bissallombardozzi.springbootserver.Actor.Actor;
import com.bissallombardozzi.springbootserver.Genres.Genre;
import com.bissallombardozzi.springbootserver.Movie.Movie;
import com.bissallombardozzi.springbootserver.Poster.Poster;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MoviesExtendedDetails {
    private Long id;
    private String title;
    private String tagline;
    private String description;
    private String duration;
    private String releaseDate;
    private List<String> genres;
    private List<String> languages;
    private String posterUrl;
    private List<ActorDetails> actors;
    private float rating;


    public MoviesExtendedDetails(Movie m, Poster p, List<ActorDetails> actors) {
        this.id = m.getId();
        this.title = m.getFilmName();
        this.description = m.getFilmDescription();
        this.releaseDate = m.getFilmDate();
        this.rating = m.getFilmRating();
        this.tagline = m.getFilmTagline();
        this.duration = m.getFilmDuration();

        if (m.getGenres() == null) {
            this.genres = List.of();
        } else {
            this.genres = m.getGenres().stream()
                    .map(Genre::getGenre)
                    .collect(Collectors.toList());
        }

//        if (m.getFilmLanguages() == null) {
//            this.languages = List.of();
//        } else {
//            this.languages = List.of(m.getFilmLanguages().split(",")); // idem per le lingue
//        }

        this.posterUrl = p.getLink();
        this.actors = actors;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getTagline() { return tagline; }
    public void setTagline(String tagline) { this.tagline = tagline; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public List<String> getGenres() { return genres; }
    public void setGenres(List<String> genres) { this.genres = genres; }

    public List<String> getLanguages() { return languages; }
    public void setLanguages(List<String> languages) { this.languages = languages; }

    public String getPosterUrl() { return posterUrl; }
    public void setPosterUrl(String posterUrl) { this.posterUrl = posterUrl; }

    public List<ActorDetails> getActors() { return actors; }
    public void setActors(List<ActorDetails> actors) {
        this.actors = actors;
    }

    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }
}
