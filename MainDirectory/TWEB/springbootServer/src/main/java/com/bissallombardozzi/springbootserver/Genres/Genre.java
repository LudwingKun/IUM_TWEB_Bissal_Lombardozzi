package com.bissallombardozzi.springbootserver.Genres;



import jakarta.persistence.*;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unique")
    private Long idUnique;

    @Column(name = "id")
    private Integer genre_id;
    @Column(name = "genre")
    private String genre;

    public Long getIdUnique() {
        return idUnique;
    }

    public void setIdUnique(Long idUnique) {
        this.idUnique = idUnique;
    }

    public Integer getId() {
        return genre_id;
    }

    public void setId(Integer id) {
        this.genre_id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}