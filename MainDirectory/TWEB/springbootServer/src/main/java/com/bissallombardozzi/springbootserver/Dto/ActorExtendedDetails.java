package com.bissallombardozzi.springbootserver.Dto;

import java.util.List;
import java.util.Map;

public class ActorExtendedDetails {
    private String name;
    private Map<String, String> rolesPlayed;
    private int numberOfOscars;
    private List<String> oscarAwards;

    public ActorExtendedDetails() {
    }

    public ActorExtendedDetails(String name, Map<String, String> rolesPlayed, int numberOfOscars, List<String> oscarAwards) {
        this.name = name;
        this.rolesPlayed = rolesPlayed;
        this.numberOfOscars = numberOfOscars;
        this.oscarAwards = oscarAwards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getRolesPlayed() {
        return rolesPlayed;
    }

    public void setRolesPlayed(Map<String, String> rolesPlayed) {
        this.rolesPlayed = rolesPlayed;
    }

    public int getNumberOfOscars() {
        return numberOfOscars;
    }

    public void setNumberOfOscars(int numberOfOscars) {
        this.numberOfOscars = numberOfOscars;
    }

    public List<String> getOscarAwards() {
        return oscarAwards;
    }

    public void setOscarAwards(List<String> oscarAwards) {
        this.oscarAwards = oscarAwards;
    }
}
