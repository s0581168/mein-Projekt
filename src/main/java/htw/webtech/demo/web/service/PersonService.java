package htw.webtech.demo.web.service;

import htw.webtech.demo.persistence.PersonEnity;
import htw.webtech.demo.persistence.PersonRepository;
import htw.webtech.demo.web.api.Person;
import htw.webtech.demo.web.api.PersonCreateRequest;
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
        return persons.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public Person create(PersonCreateRequest request) {
        var personEntity = new PersonEnity(request.getFirstName(), request.getLastName());
        personEntity = personRepository.save(personEntity);
        return transformEntity(personEntity);

    }

    private Person transformEntity(PersonEnity personEnity){
        return new Person(
                personEnity.getId(),
                personEnity.getFirstName(),
                personEnity.getLastName()

        );
    }
}
