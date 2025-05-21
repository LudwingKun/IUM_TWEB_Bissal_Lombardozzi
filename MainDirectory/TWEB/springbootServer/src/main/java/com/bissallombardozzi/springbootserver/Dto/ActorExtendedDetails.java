package com.bissallombardozzi.springbootserver.Dto;

import java.util.List;

public class ActorExtendedDetails {
    private String name;
    private int numberOfOscars;
    private List<OscarToActors> oscarAwards;
    private List<MovieDetails> movies;

    public ActorExtendedDetails() {
    }

    public ActorExtendedDetails(String name, int numberOfOscars, List<OscarToActors> oscarAwards,  List<MovieDetails> movies) {
        this.name = name;
        this.numberOfOscars = numberOfOscars;
        this.oscarAwards = oscarAwards;
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfOscars() {
        return numberOfOscars;
    }

    public void setNumberOfOscars(int numberOfOscars) {
        this.numberOfOscars = numberOfOscars;
    }

    public List<OscarToActors> getOscarAwards() {
        return oscarAwards;
    }

    public void setOscarAwards(List<OscarToActors> oscarAwards) {
        this.oscarAwards = oscarAwards;
    }

    public List<MovieDetails> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDetails> movies) {
        this.movies = movies;
    }
}
