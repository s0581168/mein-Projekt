package htw.webtech.demo.web.api;

import htw.webtech.demo.web.service.KundeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class KundeRestController {
    //Logger logger = (Logger) LoggerFactory.getLogger(PersonRestController.class);

    private final KundeService kundeService;

    public KundeRestController(KundeService kundeService){

        this.kundeService = kundeService;

    }
    @GetMapping(path = "/api/v1/kunde_verwaltung")
    //@ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Kunde>> fetchPersons(){
        return ResponseEntity.ok(kundeService.findAll());

    }

    @GetMapping(path = "/api/v1/kunde_verwaltung/{id}")
    public ResponseEntity<Kunde> fetchPersonById(@PathVariable Long id){
        var person = kundeService.findById(id);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();

    }

    @PostMapping(path = "/api/v1/kunde_verwaltung")
    public ResponseEntity<Void> createPerson(@Valid @RequestBody KundeManipulationRequest request) throws URISyntaxException {
        var valid = validate(request);
        if(valid) {
            var person = kundeService.create(request);
            URI uri = new URI("/api/v1/kunde_verwaltung/" + person.getId());
            return ResponseEntity.created(uri).build();
        }
        else {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping(path = "/api/v1/kunde_verwaltung/{id}")
    public ResponseEntity<Kunde> updatePerson(@PathVariable Long id, @RequestBody KundeManipulationRequest request ) {
        var person = kundeService.update(id, request);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
  }

    @DeleteMapping(path = "/api/v1/kunde_verwaltung/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id){
        boolean successful = kundeService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    private  boolean validate(KundeManipulationRequest request) {
        return request.getFirstName() != null
                && !request.getFirstName().isBlank()
                && request.getLastName() != null
                && !request.getLastName().isBlank()
                && request.getGeburtsDatum() != null
                && request.geteMail() != null
                && !request.geteMail().isBlank();
    }

}
