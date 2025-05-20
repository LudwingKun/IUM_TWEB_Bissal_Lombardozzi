package com.bissallombardozzi.springbootserver.Actor;

import com.bissallombardozzi.springbootserver.Dto.MovieDetails;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actors")
public class ActorController {
    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping()
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }



    @GetMapping("/{name}/movies")
    public ResponseEntity<List<MovieDetails>> getActorDetails(@PathVariable String name) {
        Optional<List<MovieDetails>> detailsOpt = actorService.getMoviesByActorName(name);
        System.out.println("detailsOpt: " + detailsOpt);
        return detailsOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Metodo fittizio per esempio, da sostituire con una query reale o integrazione
  /*  private List<String> getMockOscarsForActor(String name) {
        if (name.equalsIgnoreCase("Tom Hanks")) {
            return Arrays.asList("Best Actor (1994)", "Best Actor (1995)");
        } else if (name.equalsIgnoreCase("Meryl Streep")) {
            return Arrays.asList("Best Actress (1983)", "Best Supporting Actress (1980)", "Best Actress (2012)");
        }
        return Collections.emptyList();
    }
    */
/*
    @Autowired
    private ActorMapper actorMapper;
    public ActorDetails getActorDetails(Long id) {
        Actor actor = actorService.getActorById(id);
        return actorMapper.toDto(actor);
    }*/
}
