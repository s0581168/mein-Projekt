package htw.webtech.demo.web.service;

import htw.webtech.demo.persistence.PersonEnity;
import htw.webtech.demo.persistence.PersonRepository;
import htw.webtech.demo.web.api.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;

    }

    public List<Person> findAll(){
        List<PersonEnity> persons = personRepository.findAll();
        return (List<Person>) persons.stream()
                .map(personEnity -> new Person(
                        personEnity.getId(),
                        personEnity.getFirstName(),
                        personEnity.getLastName()
                ))
                .collect(Collectors.toList());

    }
}
