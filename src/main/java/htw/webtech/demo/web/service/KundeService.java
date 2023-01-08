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
    private final KundeTransformer kundeTransformer;

    public KundeService(KundeRepository kundeRepository, KundeTransformer kundeTransformer) {
        this.kundeRepository = kundeRepository;
        this.kundeTransformer = kundeTransformer;
    }

    public List<Kunde> findAll(){
        List<KundeEnity> kunde = kundeRepository.findAll();
        return kunde.stream()
                .map(kundeTransformer::transformEntity)
                .collect(Collectors.toList());

    }

    public Kunde findById(Long id){
        var kundeEntity = kundeRepository.findById(id);
        return kundeEntity.map(kundeTransformer::transformEntity).orElse(null);
    }

    public Kunde create(KundeManipulationRequest request) {
        var kundeEntity = new KundeEnity(request.getFirstName(), request.getLastName(), request.getGeburtsDatum(), request.getTelefonnumer());
        kundeEntity = kundeRepository.save(kundeEntity);
        return kundeTransformer.transformEntity(kundeEntity);

    }

    public Kunde update(Long id, KundeManipulationRequest request){
        var kundeEnityOptional = kundeRepository.findById(id);
        if (kundeEnityOptional.isEmpty()) {
            return null;
        }

        var kundeEnity = kundeEnityOptional.get();
        kundeEnity.setFirstName(request.getFirstName());
        kundeEnity.setLastName(request.getLastName());
        kundeEnity.setGeburtsDatum(request.getGeburtsDatum());
        kundeEnity.setTelefonnummer(request.getTelefonnumer());
        kundeEnity = kundeRepository.save(kundeEnity);

        return kundeTransformer.transformEntity(kundeEnity);
    }

    public boolean deleteById(Long id){
        if (!kundeRepository.existsById(id)){
            return false;
        }

        kundeRepository.deleteById(id);
        return true;
    }

}
