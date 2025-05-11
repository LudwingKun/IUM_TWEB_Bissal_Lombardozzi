package com.bissallombardozzi.springbootserver.Movie;

import com.bissallombardozzi.springbootserver.Actor.Actor;
import com.bissallombardozzi.springbootserver.Actor.ActorRepository;
import com.bissallombardozzi.springbootserver.Dto.ActorDetails;
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
    private final ActorRepository actorRepository;


    public MovieService(MovieRepository movieRepository, PosterRepository posterRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.posterRepository = posterRepository;
        this.actorRepository = actorRepository;
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
        Movie movie = movieRepository.findById(id).orElse(null);
        Poster poster = posterRepository.findById(id).orElse(null);
        List<ActorDetails> actors = actorRepository.findById_film(id);
        if (movie != null) {
            return new MoviesExtendedDetails(movie, poster, actors);
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
