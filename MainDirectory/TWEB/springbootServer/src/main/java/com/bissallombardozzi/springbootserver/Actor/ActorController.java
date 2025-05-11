package com.bissallombardozzi.springbootserver.Actor;

import com.bissallombardozzi.springbootserver.Dto.ActorDetails;
import com.bissallombardozzi.springbootserver.Mapper.ActorMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("id/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable Long id) {
        Actor actor = actorService.getActorById(id);
        if (actor != null) {
            return ResponseEntity.ok(actor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("name/{name}")
    public ResponseEntity<List<Actor>> getActorByName(@PathVariable String name) {
        List<Actor> actors = actorService.getActorByName(name);
        if (actors != null && !actors.isEmpty()) {
            return ResponseEntity.ok(actors);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Autowired
    private ActorMapper actorMapper;
    public ActorDetails getActorDetails(Long id) {
        Actor actor = actorService.getActorById(id);
        return actorMapper.toDto(actor);
    }
}
