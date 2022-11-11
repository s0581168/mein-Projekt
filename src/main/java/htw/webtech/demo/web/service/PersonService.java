package htw.webtech.demo.web.service;

import htw.webtech.demo.persistence.PersonEnity;
import htw.webtech.demo.persistence.PersonRepository;
import htw.webtech.demo.web.api.Person;
import htw.webtech.demo.web.api.PersonManipulationRequest;
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

    public Person findById(Long id){
        var personEntity = personRepository.findById(id);
        return personEntity.map(this::transformEntity).orElse(null);
    }

    public Person create(PersonManipulationRequest request) {
        var personEntity = new PersonEnity(request.getFirstName(), request.getLastName());
        personEntity = personRepository.save(personEntity);
        return transformEntity(personEntity);

    }

    public Person update(Long id, PersonManipulationRequest request){
        var personEnityOptional = personRepository.findById(id);
        if (personEnityOptional.isEmpty()) {
            return null;
        }

        var personEnity = personEnityOptional.get();
        personEnity.setFirstName(request.getFirstName());
        personEnity.setLastName(request.getLastName());
        personRepository.save(personEnity);

        return transformEntity(personEnity);
    }

    public boolean deleteById(Long id){
        if (!personRepository.existsById(id)){
            return false;
        }

        personRepository.deleteById(id);
        return true;
    }

    private Person transformEntity(PersonEnity personEnity){
        return new Person(
                personEnity.getId(),
                personEnity.getFirstName(),
                personEnity.getLastName()

        );
    }
}
