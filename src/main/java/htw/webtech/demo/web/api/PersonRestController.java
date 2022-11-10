package htw.webtech.demo.web.api;

import htw.webtech.demo.persistence.PersonRepository;
import htw.webtech.demo.web.api.Person;
import htw.webtech.demo.web.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
}
