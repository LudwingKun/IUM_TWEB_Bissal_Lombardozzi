package com.bissallombardozzi.springbootserver.Dto;

import java.util.List;

public class IndexData {
    private List<OscarEditionInfo> last5editions;
    private List<MovieDetails> bestMovies;
    private List<MovieDetails> suggestedMovies;

    public IndexData(List<OscarEditionInfo> last5editions, List<MovieDetails> bestMovies, List<MovieDetails> suggestedMovies) {
        this.last5editions = last5editions;
        this.bestMovies = bestMovies;
        this.suggestedMovies = suggestedMovies;
    }

    public List<OscarEditionInfo> getLast5editions() {
        return last5editions;
    }

    public void setLast5editions(List<OscarEditionInfo> last5editions) {
        this.last5editions = last5editions;
    }

    public List<MovieDetails> getBestMovies() {
        return bestMovies;
    }

    public void setBestMovies(List<MovieDetails> bestMovies) {
        this.bestMovies = bestMovies;
    }

    public List<MovieDetails> getSuggestedMovies() {
        return suggestedMovies;
    }

    public void setSuggestedMovies(List<MovieDetails> suggestedMovies) {
        this.suggestedMovies = suggestedMovies;
    }
}
