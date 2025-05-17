package com.bissallombardozzi.springbootserver.Movie;

import com.bissallombardozzi.springbootserver.Dto.MovieDetails;
import com.bissallombardozzi.springbootserver.Dto.MoviePageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bissallombardozzi.springbootserver.Dto.MoviesExtendedDetails;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
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

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/search")
    public ResponseEntity<MoviePageDTO> searchMovies(
            @RequestParam(required = false) String filmName,
            @RequestParam(required = false) String filmDate,
            @RequestParam(required = false) Double rating,
            @RequestParam(required = false) String genre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {

        Page<MovieDetails> result = movieService.searchMovies(filmName, filmDate, rating, genre, page, size);
        return ResponseEntity.ok(new MoviePageDTO(result));
    }
/*
    @GetMapping("/search")
    public List<Movie> searchMovies(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Double rating,
            @RequestParam(required = false, defaultValue = "asc") String sort
    ) {

        return movieRepository.findMoviesByFilters(title, genre, year, rating, sort);
    }
*/
/*
@GetMapping("/search")
public ResponseEntity<List<MovieDetails>> searchMovies(
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String genre,
        @RequestParam(required = false) Integer year,
        @RequestParam(required = false) Double rating,
        @RequestParam(required = false, defaultValue = "asc") String sort
) {
    List<MovieDetails> movies = movieService.searchMovies(title, genre, year, rating, sort);

    if (movies != null && !movies.isEmpty()) {
        return ResponseEntity.ok(movies);
    } else {
        return ResponseEntity.notFound().build();
    }
}
*/




    @GetMapping("/top5movies")
    public List<MovieDetails> getTop5Movies() {
        return movieService.getTop5Movies();
    }


//    @GetMapping("/movies/{name}")
//    public List<Movie> getMovieByName(@PathVariable String name) {
//        return movieService.getMovieByName(name);
//    }


}
