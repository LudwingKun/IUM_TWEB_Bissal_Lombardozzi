package com.bissallombardozzi.springbootserver.Poster;

public class PosterService {
    private final PosterRepository posterRepository;

    public PosterService(PosterRepository posterRepository) {
        this.posterRepository = posterRepository;
    }

    public Poster getPosterById(Long id) {
        return posterRepository.findByIdFilm(id);
    }

    public Poster savePoster(Poster poster) {
        return posterRepository.save(poster);
    }

    public void deletePoster(Long id) {
        posterRepository.deleteById(id);
    }
}
