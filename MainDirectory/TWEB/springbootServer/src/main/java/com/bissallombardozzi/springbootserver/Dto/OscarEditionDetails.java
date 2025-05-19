package com.bissallombardozzi.springbootserver.Dto;

import java.util.List;
import java.util.Map;

public class OscarEditionDetails {
    private int edition;
    private int year;
    private Map<String, String> nominations;
    private List<String> winners;

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Map<String, String> getNominations() {
        return nominations;
    }

    public void setNominations(Map<String, String> nominations) {
        this.nominations = nominations;
    }

    public List<String> getWinners() {
        return winners;
    }

    public void setWinners(List<String> winners) {
        this.winners = winners;
    }
}