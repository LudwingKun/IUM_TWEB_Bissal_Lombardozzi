package com.bissallombardozzi.springbootserver.Actor;

import com.bissallombardozzi.springbootserver.Dto.ActorExtendedDetails;
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
    public ResponseEntity<ActorExtendedDetails> getActorDetails(@PathVariable String name) {
        Optional<ActorExtendedDetails> detailsOpt = actorService.getMoviesByActorName(name);
        System.out.println("detailsOpt: " + detailsOpt);
        return detailsOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
