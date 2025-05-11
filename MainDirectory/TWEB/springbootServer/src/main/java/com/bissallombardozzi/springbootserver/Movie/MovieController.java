package com.bissallombardozzi.springbootserver.Movie;

import com.bissallombardozzi.springbootserver.Dto.MovieDetails;
import com.bissallombardozzi.springbootserver.Movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bissallombardozzi.springbootserver.Dto.MoviesExtendedDetails;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDetails> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoviesExtendedDetails> getMovieById(@PathVariable Long id) {
        MoviesExtendedDetails movie_dto = movieService.getMovieById(id);

        if (movie_dto != null) {
            return ResponseEntity.ok(movie_dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/top5movies")
    public List<MovieDetails> getTop5Movies() {
        return movieService.getTop5Movies();
    }


//    @GetMapping("/movies/{name}")
//    public List<Movie> getMovieByName(@PathVariable String name) {
//        return movieService.getMovieByName(name);
//    }


}
