package htw.webtech.demo.web.api;


import htw.webtech.demo.web.service.TerminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class TerminRestController {
    private final TerminService terminService;

    public TerminRestController(TerminService terminService) {
        this.terminService = terminService;
    }

    @GetMapping(path = "/api/v1/termine")
    public ResponseEntity<List<Termin>> fetchPets() {
        return ResponseEntity.ok(terminService.findAll());
    }

    @PostMapping(path = "/api/v1/termine")
    public ResponseEntity<Void> createPet(@RequestBody TerminManipulationRequest request) throws URISyntaxException {
        var termin = terminService.create(request);
        URI uri = new URI("/api/v1/termine/" + termin.getId());
        return ResponseEntity.created(uri).build();
    }
}
