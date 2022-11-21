package htw.webtech.demo.web.service;

import htw.webtech.demo.persistence.KundeEnity;
import htw.webtech.demo.persistence.KundeRepository;
import htw.webtech.demo.web.api.Kunde;
import htw.webtech.demo.web.api.KundeManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KundeService {

    private final KundeRepository kundeRepository;

    public KundeService(KundeRepository kundeRepository){
        this.kundeRepository = kundeRepository;

    }

    public List<Kunde> findAll(){
        List<KundeEnity> kunde = kundeRepository.findAll();
        return kunde.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public Kunde findById(Long id){
        var personEntity = kundeRepository.findById(id);
        return personEntity.map(this::transformEntity).orElse(null);
    }

    public Kunde create(KundeManipulationRequest request) {
        var kundeEntity = new KundeEnity(request.getFirstName(), request.getLastName(), request.getGeburtsDatum(), request.geteMail());
        kundeEntity = kundeRepository.save(kundeEntity);
        return transformEntity(kundeEntity);

    }

    public Kunde update(Long id, KundeManipulationRequest request){
        var personEnityOptional = kundeRepository.findById(id);
        if (personEnityOptional.isEmpty()) {
            return null;
        }

        var personEnity = personEnityOptional.get();
        personEnity.setFirstName(request.getFirstName());
        personEnity.setLastName(request.getLastName());
        personEnity.setGeburtsDatum(request.getGeburtsDatum());
        personEnity.seteMail(request.geteMail());
        kundeRepository.save(personEnity);

        return transformEntity(personEnity);
    }

    public boolean deleteById(Long id){
        if (!kundeRepository.existsById(id)){
            return false;
        }

        kundeRepository.deleteById(id);
        return true;
    }

    private Kunde transformEntity(KundeEnity kundeEnity){
        return new Kunde(
                kundeEnity.getId(),
                kundeEnity.getFirstName(),
                kundeEnity.getLastName(),
                kundeEnity.getGeburtsDatum(),
                kundeEnity.geteMail()

        );
    }
}
