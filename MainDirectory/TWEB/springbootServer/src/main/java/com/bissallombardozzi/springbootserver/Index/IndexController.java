package com.bissallombardozzi.springbootserver.Index;


import com.bissallombardozzi.springbootserver.Dto.IndexData;
import com.bissallombardozzi.springbootserver.Dto.MovieDetails;
import com.bissallombardozzi.springbootserver.Dto.OscarEditionInfo;
import com.bissallombardozzi.springbootserver.Movie.MovieService;
import com.bissallombardozzi.springbootserver.Oscars.OscarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/index-data")
public class IndexController {
    private final MovieService movieService;
    private final OscarService oscarService;

    @Autowired
    public IndexController(MovieService movieService, OscarService oscarService) {
        this.movieService = movieService;
        this.oscarService = oscarService;
    }

    @GetMapping
    public IndexData getIndexData() {
        List<MovieDetails> top5Movies = movieService.getTop5Movies();
        List <MovieDetails> suggestedMovies = movieService.get5RandomMovies();
        List <OscarEditionInfo> last5Editions = oscarService.get5LatestEditions();

         return new IndexData(last5Editions, top5Movies, suggestedMovies);
    }
}
