package com.bissallombardozzi.springbootserver.Oscars;

import com.bissallombardozzi.springbootserver.Dto.OscarEditionDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/oscars")
public class OscarController {

    @Autowired
    private OscarService oscarService;

    public OscarController(OscarService oscarService) {
        this.oscarService = oscarService;
    }
    @GetMapping("/year/{year}")
    public ResponseEntity<OscarEditionDetails> getEditionByYear(@PathVariable int year) {
        OscarEditionDetails details = oscarService.getOscarEditionDetailsByYear(year);
        if (details == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(details);
    }

    @GetMapping("/edition/{edition}")
    public ResponseEntity<OscarEditionDetails> getEditionByCeremony(@PathVariable int edition) {
        OscarEditionDetails details = oscarService.getOscarEditionDetailsByEdition(edition);
        if (details == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(details);
    }
}
