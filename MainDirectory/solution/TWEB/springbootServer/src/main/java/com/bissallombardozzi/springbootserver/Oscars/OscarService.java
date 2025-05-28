package com.bissallombardozzi.springbootserver.Oscars;

import com.bissallombardozzi.springbootserver.Dto.OscarEditionDetails;
import com.bissallombardozzi.springbootserver.Dto.OscarEditionInfo;
import com.bissallombardozzi.springbootserver.Dto.OscarToActors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OscarService {

    @Autowired
    private OscarRepository oscarRepository;

    public OscarEditionDetails getOscarEditionDetailsByYear(int year) {
        List<Oscar> oscars = oscarRepository.findByYearCeremony(year);

        if (oscars == null || oscars.isEmpty()) {
            return null;
        }

        OscarEditionDetails details = new OscarEditionDetails();
        details.setYear(year);
        details.setEdition(oscars.get(0).getCeremony());

        Map<String, String> nominations = new LinkedHashMap<>();
        Map<String, String> winners = new LinkedHashMap<>();

        for (Oscar oscar : oscars) {
            nominations.put(oscar.getName(), oscar.getMovieName());
            if (oscar.getWinner()) {
                winners.put(oscar.getName(), oscar.getCategoryOscar());
            }
        }

        details.setNominations(nominations);
        details.setWinners(winners);
        return details;
    }

    public OscarEditionDetails getOscarEditionDetailsByEdition(int edition) {
        List<Oscar> oscars = oscarRepository.findByCeremony(edition);

        if (oscars == null || oscars.isEmpty()) {
            return null;
        }

        OscarEditionDetails details = new OscarEditionDetails();
        details.setYear(oscars.get(0).getYearCeremony());
        details.setEdition(edition);

        Map<String, String> nominations = new LinkedHashMap<>();
        Map<String, String> winners = new LinkedHashMap<>();

        for (Oscar oscar : oscars) {
            nominations.put(oscar.getName(), oscar.getMovieName());
            if (oscar.getWinner()) {
                winners.put(oscar.getName(), oscar.getCategoryOscar());
            }
        }

        details.setNominations(nominations);
        details.setWinners(winners);
        return details;
    }

    public List<OscarEditionInfo> get5LatestEditions() {
        List<Oscar> oscars = oscarRepository.findTop5CeremonyDistinctOrderByYearCeremonyDesc();
        List<OscarEditionInfo> editions = new ArrayList<>();

        System.out.println("Oscars: " + oscars);

        for(Oscar oscar : oscars) {
            OscarEditionInfo editionInfo = new OscarEditionInfo();
            editionInfo.setEdition(oscar.getCeremony());
            editionInfo.setYear(oscar.getYearCeremony());
            editionInfo.setNumberOfWinners((int) oscars.stream().filter(Oscar::getWinner).count());
            editions.add(editionInfo);
        }

        return editions;
    }

    public List<OscarToActors> convertToOscarToActorsList(List<Oscar> oscars) {
        return oscars.stream()
                .map(o -> new OscarToActors(
                        o.getYearFilm(),
                        o.getYearCeremony(),
                        o.getCategoryOscar(),
                        o.getName(),
                        o.getMovieName()
                ))
                .collect(Collectors.toList());
    }
}