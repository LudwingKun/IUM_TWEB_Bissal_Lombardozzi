package com.bissallombardozzi.springbootserver.Dto;
import com.bissallombardozzi.springbootserver.Movie.Movie;
import com.bissallombardozzi.springbootserver.Poster.Poster;

public class MovieDetails {
    private Long id;
    private String title;
    private String posterUrl;
    private String releaseDate;
    private String tagline;
    private float rating;

    public MovieDetails(Movie movie, Poster poster) {
        this.id = movie.getId();
        this.title = movie.getFilmName();
        this.posterUrl = poster.getLink();
        this.releaseDate = movie.getFilmDate();
        this.tagline = movie.getFilmTagline();
        this.rating = movie.getFilmRating();
    }

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

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
