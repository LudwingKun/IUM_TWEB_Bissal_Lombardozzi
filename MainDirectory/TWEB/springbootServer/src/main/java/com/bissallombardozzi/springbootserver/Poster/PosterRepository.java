package com.bissallombardozzi.springbootserver.Poster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PosterRepository extends JpaRepository<Poster, Long> {

    @Query("SELECT p FROM Poster p WHERE p.id = :idFilm")
    Poster findByIdFilm(Long idFilm);
}
