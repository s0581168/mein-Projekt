package htw.webtech.demo.web.api;

import htw.webtech.demo.persistence.PersonRepository;
import htw.webtech.demo.web.api.Person;
import htw.webtech.demo.web.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PersonRestController {
    //Logger logger = (Logger) LoggerFactory.getLogger(PersonRestController.class);

    private final PersonService personService;

    public PersonRestController(PersonService personService){

        this.personService = personService;

    }
    @GetMapping(path = "/api/v1/persons")
    //@ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Person>> fetchPersons(){
        return ResponseEntity.ok(personService.findAll());

    }
    @PostMapping(path = "/api/v1/persons")
    public ResponseEntity<Void> createPerson(@RequestBody PersonCreateRequest request) throws URISyntaxException {
        var person = personService.create(request);
        URI uri = new URI("/api/v1/persons" + person.getId());
        return ResponseEntity.created(uri).build();

    }

}
