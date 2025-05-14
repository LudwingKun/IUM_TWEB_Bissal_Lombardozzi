package com.bissallombardozzi.springbootserver.Genres;



import com.bissallombardozzi.springbootserver.Movie.Movie;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table (name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String genre;

    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies;

    public Genre() {}

    public Genre(String genre) {
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}