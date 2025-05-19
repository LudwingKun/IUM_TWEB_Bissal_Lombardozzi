package com.bissallombardozzi.springbootserver.Oscars;

import com.bissallombardozzi.springbootserver.Dto.OscarEditionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        List<String> winners = new ArrayList<>();

        for (Oscar oscar : oscars) {
            nominations.put(oscar.getName(), oscar.getMovieName());
            if (oscar.getWinner()) {
                winners.add(oscar.getName() + " - " + oscar.getCategoryOscar());
            }
        }

        details.setNominations(nominations);
        details.setWinners(winners);
        return details;
    }

    public OscarEditionDetails getOscarEditionDetailsByEdition(int edition) {
        List<Oscar> oscars = oscarRepository.findByCeremony(edition);

        if (oscars == null || oscars.isEmpty()) {
            return null; //
        }

        OscarEditionDetails details = new OscarEditionDetails();
        details.setYear(oscars.get(0).getYearCeremony());
        details.setEdition(edition);

        Map<String, String> nominations = new LinkedHashMap<>();
        List<String> winners = new ArrayList<>();

        for (Oscar oscar : oscars) {
            nominations.put(oscar.getName(), oscar.getMovieName());
            if (oscar.getWinner()) {
                winners.add(oscar.getName() + " - " + oscar.getCategoryOscar());
            }
        }

        details.setNominations(nominations);
        details.setWinners(winners);
        return details;
    }
}