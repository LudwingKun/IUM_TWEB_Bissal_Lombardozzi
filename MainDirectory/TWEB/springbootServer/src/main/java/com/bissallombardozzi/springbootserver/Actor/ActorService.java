package com.bissallombardozzi.springbootserver.Actor;

import com.bissallombardozzi.springbootserver.Dto.ActorExtendedDetails;
import com.bissallombardozzi.springbootserver.Dto.MovieDetails;
import com.bissallombardozzi.springbootserver.Movie.Movie;
import com.bissallombardozzi.springbootserver.Poster.Poster;
import com.bissallombardozzi.springbootserver.Poster.PosterRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ActorService {
    private final ActorRepository actorRepository;
    private final PosterRepository posterRepository;

    public ActorService(ActorRepository actorRepository, PosterRepository posterRepository) {
        this.actorRepository = actorRepository;
        this.posterRepository = posterRepository;
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

    public Optional<List<MovieDetails>> getMoviesByActorName(String name) {
        List<Actor> actorRoles = actorRepository.findByActorName(name);
        System.out.println("actorRoles: " + actorRoles);

        if (actorRoles.isEmpty()) {
            return Optional.empty();
        }

        // Costruisci la lista di MovieDetails, filtrando eventuali null per sicurezza
        List<MovieDetails> movieDetailsList = actorRoles.stream()
                .filter(actor -> actor.getMovie() != null) // evita NPE
                .map(actor -> {
                    Movie movie = actor.getMovie();
                    Poster poster = posterRepository.findById(movie.getId()).orElse(null);
                    return new MovieDetails(movie, poster);
                })
                .distinct() // se vuoi evitare duplicati di MovieDetails (da attori duplicati)
                .toList();

        return Optional.of(movieDetailsList);
    }

}
