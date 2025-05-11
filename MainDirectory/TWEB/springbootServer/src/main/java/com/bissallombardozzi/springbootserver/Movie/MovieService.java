package com.bissallombardozzi.springbootserver.Movie;

import com.bissallombardozzi.springbootserver.Dto.MovieDetails;
import com.bissallombardozzi.springbootserver.Dto.MoviesExtendedDetails;
import com.bissallombardozzi.springbootserver.Poster.Poster;
import com.bissallombardozzi.springbootserver.Poster.PosterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final PosterRepository posterRepository;


    public MovieService(MovieRepository movieRepository, PosterRepository posterRepository) {
        this.movieRepository = movieRepository;
        this.posterRepository = posterRepository;
    }

    public List<MovieDetails> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieDetails> movieDetailsList = new ArrayList<>();
        for (Movie movie : movies) {
            Poster poster = posterRepository.findById(movie.getId()).orElse(null);
            if (poster != null) {
                MovieDetails movieDetails = new MovieDetails(movie, poster);
                movieDetailsList.add(movieDetails);
            }
        }
        return movieDetailsList;
    }

    public MoviesExtendedDetails getMovieById(Long id) {
        Movie m = movieRepository.findById(id).orElse(null);
        Poster p = posterRepository.findById(id).orElse(null);
        if (m != null) {
            return new MoviesExtendedDetails(m, p);
        } else {
            return null;
        }
    }

    public List<MovieDetails> getTop5Movies() {
        List<Movie> movies = movieRepository.findTop5ByOrderByRatingDesc().subList(0, 5);
        List<MovieDetails> movieDetailsList = new ArrayList<>();
        for (Movie movie : movies) {
            Poster poster = posterRepository.findById(movie.getId()).orElse(null);
            if (poster != null) {
                MovieDetails movieDetails = new MovieDetails(movie, poster);
                movieDetailsList.add(movieDetails);
            }
        }
        return movieDetailsList;
    }
}
