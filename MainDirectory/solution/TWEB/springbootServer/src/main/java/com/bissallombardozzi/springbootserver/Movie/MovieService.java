package com.bissallombardozzi.springbootserver.Movie;

import com.bissallombardozzi.springbootserver.Actor.ActorRepository;
import com.bissallombardozzi.springbootserver.Dto.ActorDetails;
import com.bissallombardozzi.springbootserver.Dto.MovieDetails;
import com.bissallombardozzi.springbootserver.Dto.MoviesExtendedDetails;
import com.bissallombardozzi.springbootserver.Language.Language;
import com.bissallombardozzi.springbootserver.Poster.Poster;
import com.bissallombardozzi.springbootserver.Poster.PosterRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        Set<String> languages = new java.util.HashSet<>();

        if (movie != null && movie.getLanguages() != null) {
            languages = movie.getLanguages().stream()
                    .map(Language::getLanguage)
                    .collect(Collectors.toSet());
        }
        if (movie != null) {
            assert poster != null;
            return new MoviesExtendedDetails(movie, poster, actors,languages );
        } else {
            return null;
        }
    }

    public List<MovieDetails> getTop5Movies() {
        List<Movie> movies = movieRepository.findTop5ByOrderByRatingDesc();
        return getMovieDetails(movies);
    }


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

    public List<MovieDetails> get5RandomMovies() {
        List<Movie> movies = movieRepository.findRandomMovies();
        return getMovieDetails(movies);
    }

    public Page<MovieDetails> searchMovies(String filmName, String filmDate, Double rating, String genre, String sort, String order, int page, int size) {
        Sort sortOrder;
        Sort.Direction direction = "desc".equalsIgnoreCase(order) ? Sort.Direction.DESC : Sort.Direction.ASC;
        System.out.println("sort direction: " + direction);
        System.out.println("sort order: " + sort);
        switch (sort != null ? sort.toLowerCase() : "") {
            case "filmname":
                sortOrder = Sort.by(direction,"filmName");
                break;
            case "year":
            case "filmdate":
                sortOrder = Sort.by(direction, "filmDate");
                break;
            case "rating":
                sortOrder = Sort.by(direction, "filmRating");
                break;
            default:
                sortOrder = Sort.unsorted(); // Nessun ordinamento
        }

        Pageable pageable = PageRequest.of(page, size, sortOrder);
        Page<Movie> moviePage = movieRepository.findMovies(filmName, filmDate, rating, genre, pageable);

        return moviePage.map(movie -> {
            Poster poster = posterRepository.findById(movie.getId()).orElse(null);
            assert poster != null;
            return new MovieDetails(movie, poster);
        });

    }
}
