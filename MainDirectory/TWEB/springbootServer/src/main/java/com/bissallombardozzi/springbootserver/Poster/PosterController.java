package com.bissallombardozzi.springbootserver.Poster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posters")
public class PosterController {

    @Autowired
    private PosterRepository posterRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getPosterById(@PathVariable Long id) {
        return posterRepository.findById(id)
                .map(poster -> ResponseEntity.ok().body(poster))
                .orElse(ResponseEntity.notFound().build());
    }
}