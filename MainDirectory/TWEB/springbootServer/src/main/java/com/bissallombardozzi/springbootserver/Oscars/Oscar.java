package com.bissallombardozzi.springbootserver.Oscars;

import jakarta.persistence.*;

@Entity
@Table(name = "oscars_awards")
public class Oscar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unique", nullable = false)
    private Long id;

    @Column(name = "year_film", nullable = false)
    private int yearFilm;

    @Column(name = "year_ceremony", nullable = false)
    private int yearCeremony;

    @Column(name = "ceremony", nullable = false)
    private int ceremonyEdition;

    @Column(name = "category", nullable = false)
    private String categoryOscar;

    @Column(name = "name", length = 500)
    private String castMemberName;

    @Column(name = "film", nullable = false)
    private String movieName;

    @Column(name = "winner", nullable = false)
    private Boolean winner;

    public Oscar() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYearFilm() {
        return yearFilm;
    }

    public void setYearFilm(int yearFilm) {
        this.yearFilm = yearFilm;
    }

    public int getYearCeremony() {
        return yearCeremony;
    }

    public void setYearCeremony(int yearCeremony) {
        this.yearCeremony = yearCeremony;
    }

    public int getCeremony() {
        return ceremonyEdition;
    }

    public void setCeremony(int ceremony) {
        this.ceremonyEdition = ceremony;
    }

    public String getCategoryOscar() {
        return categoryOscar;
    }

    public void setCategoryOscar(String categoryOscar) {
        this.categoryOscar = categoryOscar;
    }

    public String getName() {
        return castMemberName;
    }

    public void setName(String name) {
        this.castMemberName = name;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Boolean getWinner() {
        return winner;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }
}