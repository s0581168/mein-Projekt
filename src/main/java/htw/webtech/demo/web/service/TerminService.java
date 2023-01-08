package htw.webtech.demo.web.service;

import htw.webtech.demo.persistence.KundeEnity;
import htw.webtech.demo.persistence.KundeRepository;
import htw.webtech.demo.persistence.TerminEntity;
import htw.webtech.demo.persistence.TerminRepository;
import htw.webtech.demo.web.api.Kunde;
import htw.webtech.demo.web.api.KundeManipulationRequest;
import htw.webtech.demo.web.api.Termin;
import htw.webtech.demo.web.api.TerminManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TerminService {

    private final TerminRepository terminRepository;
    private final KundeRepository kundeRepository;
    private final KundeTransformer kundeTransformer;

    public TerminService(TerminRepository terminRepository, KundeRepository kundeRepository, KundeTransformer kundeTransformer) {
        this.terminRepository = terminRepository;
        this.kundeRepository = kundeRepository;
        this.kundeTransformer = kundeTransformer;
    }

    public List<Termin> findAll(){
        List<TerminEntity> termine = terminRepository.findAll();
        return termine.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public Termin create(TerminManipulationRequest request) {
        var owner = kundeRepository.findById(request.getOwnerId()).orElseThrow();
        var terminEntity = new TerminEntity(request.getTermindate() , owner);
        terminEntity = terminRepository.save(terminEntity);
        return transformEntity(terminEntity);
    }

    private Termin transformEntity(TerminEntity terminEntity) {
        return new Termin(
                terminEntity.getId(),
                terminEntity.getTermindate(),
                kundeTransformer.transformEntity(terminEntity.getOwner()));
    }


}
