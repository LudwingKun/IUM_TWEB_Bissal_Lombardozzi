package com.bissallombardozzi.springbootserver.Actor;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ActorService {
    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Actor getActorById(Long id) {
        return actorRepository.findById(id).orElse(null);
    }

    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }

    public List<Actor> getActorByName(String name) {
        return actorRepository.findByActorName(name);
    }
}
