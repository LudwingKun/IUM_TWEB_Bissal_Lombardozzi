package com.bissallombardozzi.springbootserver.Movie;

import com.bissallombardozzi.springbootserver.Genres.Genre;
import com.bissallombardozzi.springbootserver.Language.Language;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String filmName;

    @Column(name = "date", nullable = false)
    private String filmDate;

    @Column(name = "tagline", nullable = false)
    private String filmTagline;

    @Column(name = "minute", nullable = false)
    private String filmDuration;

    @Column(name = "description", length = 10000, nullable = false)
    private String filmDescription;

    @Column(name = "rating", nullable = false)
    private Double filmRating;

    @ManyToMany
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;



    @ManyToMany
    @JoinTable(
            name = "movie_languages",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private Set<Language> languages;
    public Set<Language> getLanguages() {
        return languages;
    }
    public Movie() {

    }

    public Movie(Long id_film, String filmName, String filmDate, String filmTagline, String filmDuration, String filmDescription, Double filmRating) {
        this.id = id_film;
        this.filmName = filmName;
        this.filmDate = filmDate;
        this.filmTagline = filmTagline;
        this.filmDuration = filmDuration;
        this.filmDescription = filmDescription;
        this.filmRating = filmRating;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmDate() {
        return filmDate;
    }

    public void setFilmDate(String filmDate) {
        this.filmDate = filmDate;
    }

    public String getFilmTagline() {
        return filmTagline;
    }

    public void setFilmTagline(String filmTagline) {
        this.filmTagline = filmTagline;
    }

    public String getFilmDuration() {
        return filmDuration;
    }

    public void setFilmDuration(String filmDuration) {
        this.filmDuration = filmDuration;
    }

    public String getFilmDescription() {
        return filmDescription;
    }

    public void setFilmDescription(String filmDescription) {
        this.filmDescription = filmDescription;
    }

    public Double getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(Double filmRating) {
        this.filmRating = filmRating;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

}
