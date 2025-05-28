package com.bissallombardozzi.springbootserver.Dto;

public class OscarToActors {
    private final int yearFilm;
    private int yearCeremony;
    private String category;
    private String nameActor;
    private String nameFilm;

    public OscarToActors(int yearFilm, int yearCeremony, String category, String nameActor,String nameFilm) {
        this.yearFilm = yearFilm;
        this.yearCeremony = yearCeremony;
        this.category = category;
        this.nameActor = nameActor;
        this.nameFilm = nameFilm;
    }

    public int getYearFilm() {
        return yearFilm;
    }

    public int getYearCeremony() {
        return yearCeremony;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public String getCategory() {
        return category;
    }

    public String getNameActor() {
        return nameActor;
    }
}
