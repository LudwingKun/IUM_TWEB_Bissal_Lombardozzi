package com.bissallombardozzi.springbootserver.Movie;

import com.bissallombardozzi.springbootserver.ActorDetails.ActorDetails;
import com.bissallombardozzi.springbootserver.Mapper.ActorMapper;
import com.bissallombardozzi.springbootserver.MovieDetails.MoviesDetails;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bissallombardozzi.springbootserver.Actor.*;
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
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/top5movies")
    public List<Movie> getTop5Movies() {
        return movieService.getTop5Movies();
    }


//    @GetMapping("/movies/{name}")
//    public List<Movie> getMovieByName(@PathVariable String name) {
//        return movieService.getMovieByName(name);
//    }


}
