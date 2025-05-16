package com.bissallombardozzi.springbootserver.Movie;

import com.bissallombardozzi.springbootserver.Actor.Actor;
import com.bissallombardozzi.springbootserver.Actor.ActorRepository;
import com.bissallombardozzi.springbootserver.Dto.ActorDetails;
import com.bissallombardozzi.springbootserver.Dto.MovieDetails;
import com.bissallombardozzi.springbootserver.Dto.MoviesExtendedDetails;
import com.bissallombardozzi.springbootserver.Poster.Poster;
import com.bissallombardozzi.springbootserver.Poster.PosterRepository;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


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
        return getMovieDetails(movies);
    }

    public MoviesExtendedDetails getMovieById(Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        Poster poster = posterRepository.findById(id).orElse(null);
        List<ActorDetails> actors = actorRepository.findByFilmId(id);
        if (movie != null) {
            assert poster != null;
            return new MoviesExtendedDetails(movie, poster, actors);
        } else {
            return null;
        }
    }

    public List<MovieDetails> getTop5Movies() {
        List<Movie> movies = movieRepository.findTop5ByOrderByRatingDesc().subList(0, 5);
        return getMovieDetails(movies);
    }


    public List<Movie> searchMovies(String genre, Integer year) {
        Pageable pageable = PageRequest.of(0, 20);
        return movieRepository.findMoviesByGenreAndYear(genre, year, pageable);
    }

    /*
        public List<MovieDetails> searchMovies(String filmName, Integer filmDate, Double rating, String genre) {
            List<Movie> movies = movieRepository.findMovies(filmName, filmDate, rating, genre);
            return getMovieDetails(movies);
        }
    */
    private List<MovieDetails> getMovieDetails(List<Movie> movies) {
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

    public Page<MovieDetails> searchMovies(String filmName, Integer filmDate, Double rating, String genre, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Movie> moviePage = movieRepository.findMovies(filmName, filmDate, rating, genre, pageable);

        return moviePage.map(movie -> {
            Poster poster = posterRepository.findById(movie.getId()).orElse(null);
            return new MovieDetails(movie, poster);
        });

    }
}
