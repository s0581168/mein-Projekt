package htw.webtech.demo.web.service;

import htw.webtech.demo.persistence.KundeEnity;
import htw.webtech.demo.persistence.TerminEntity;
import htw.webtech.demo.web.api.Kunde;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class KundeTransformer {

    public Kunde transformEntity(KundeEnity kundeEnity){
        var terminIDs = kundeEnity.getTermine().stream().map(TerminEntity::getId).collect(Collectors.toList());
        return new Kunde(
                kundeEnity.getId(),
                kundeEnity.getFirstName(),
                kundeEnity.getLastName(),
                kundeEnity.getGeburtsDatum(),
                kundeEnity.getTelefonnummer(),
                terminIDs);


    }
}
