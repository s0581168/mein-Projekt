package htw.webtech.demo.web;

import htw.webtech.demo.web.api.Person;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class PersonRestController {
    //Logger logger = (Logger) LoggerFactory.getLogger(PersonRestController.class);

    private List<Person> persons;

    public PersonRestController() {
        persons = new ArrayList<>();
        persons.add(new Person(1, "Thuy","Nguyen" ));
    }

    @GetMapping(path = "/api/v1/persons")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Person>> fetchPersons(){
        return ResponseEntity.ok(persons);

    }
}
