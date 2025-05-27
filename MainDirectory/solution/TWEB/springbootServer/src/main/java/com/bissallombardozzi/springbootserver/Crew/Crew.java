package com.bissallombardozzi.springbootserver.Crew;


import jakarta.persistence.*;

@Entity
@Table(name = "crew")
public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;

    @Column(name = "movie")
    private Long movieId;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "date")
    private String movieDate;

    @Column(name = "rating")
    private String movieRating;

    public Crew() {
    }

    public Crew(Long id, String name, String role, Long movieId, String movieName, String movieDate, String movieRating) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDate = movieDate;
        this.movieRating = movieRating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

}
