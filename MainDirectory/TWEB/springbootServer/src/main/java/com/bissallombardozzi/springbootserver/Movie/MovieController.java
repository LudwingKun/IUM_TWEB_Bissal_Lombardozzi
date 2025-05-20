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
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String order,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {

        Page<MovieDetails> result = movieService.searchMovies(filmName, filmDate, rating, genre,sort, order, page, size);
        return ResponseEntity.ok(new MoviePageDTO(result));
    }

    @GetMapping("/top5movies")
    public List<MovieDetails> getTop5Movies() {
        return movieService.getTop5Movies();
    }




}
