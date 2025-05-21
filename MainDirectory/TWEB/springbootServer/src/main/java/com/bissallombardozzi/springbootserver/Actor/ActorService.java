package com.bissallombardozzi.springbootserver.Actor;

import com.bissallombardozzi.springbootserver.Dto.ActorExtendedDetails;
import com.bissallombardozzi.springbootserver.Dto.MovieDetails;
import com.bissallombardozzi.springbootserver.Dto.OscarToActors;
import com.bissallombardozzi.springbootserver.Movie.Movie;
import com.bissallombardozzi.springbootserver.Oscars.Oscar;
import com.bissallombardozzi.springbootserver.Oscars.OscarRepository;
import com.bissallombardozzi.springbootserver.Oscars.OscarService;
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
    private final OscarRepository oscarRepository;
    private final OscarService oscarService = new OscarService();

    public ActorService(ActorRepository actorRepository, PosterRepository posterRepository, OscarRepository oscarRepository) {
        this.actorRepository = actorRepository;
        this.posterRepository = posterRepository;
        this.oscarRepository = oscarRepository;
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

    public Optional<ActorExtendedDetails> getMoviesByActorName(String name) {
        List<Actor> actorRoles = actorRepository.findByActorName(name);
        System.out.println("actorRoles: " + actorRoles);

        if (actorRoles.isEmpty()) {
            return Optional.empty();
        }

        List<MovieDetails> movieDetailsList = actorRoles.stream()
                .filter(actor -> actor.getMovie() != null) // evita NPE
                .map(actor -> {
                    Movie movie = actor.getMovie();
                    Poster poster = posterRepository.findById(movie.getId()).orElse(null);
                    assert poster != null;
                    return new MovieDetails(movie, poster);
                })
                .distinct()
                .toList();
        List<OscarToActors> oscars = oscarService.convertToOscarToActorsList(oscarRepository.findOscarsByName(name));
        ActorExtendedDetails actorExtendedDetails = new ActorExtendedDetails(name, oscars.size(), oscars, movieDetailsList);
        return Optional.of(actorExtendedDetails);
    }

}
