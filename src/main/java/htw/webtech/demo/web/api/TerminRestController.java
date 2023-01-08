package htw.webtech.demo.web.api;


import htw.webtech.demo.web.service.TerminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(path = "/api/v1/termine/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id){
        boolean successful = terminService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
