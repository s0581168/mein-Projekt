package service;

import htw.webtech.demo.persistence.KundeEnity;
import htw.webtech.demo.persistence.TerminEntity;
import htw.webtech.demo.web.service.KundeTransformer;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.doReturn;

public class TransformerTest implements WithAssertions {
    private final KundeTransformer underTest = new KundeTransformer();

    @Test
    @DisplayName("should transform KundeEntity to Kunde")
    void should_transform_kunde_entity_to_kunde() {
        LocalDate Local_Date = LocalDate.of(1989, 01, 13);
        // given
        var kundeEntity = Mockito.mock(KundeEnity.class);
        doReturn(111L).when(kundeEntity).getId();
        doReturn("John").when(kundeEntity).getFirstName();
        doReturn("Doe").when(kundeEntity).getLastName();
        doReturn(Local_Date).when(kundeEntity).getGeburtsDatum();
        doReturn(1234).when(kundeEntity).getTelefonnummer();
        doReturn(List.of(new TerminEntity())).when(kundeEntity).getTermine();

        // when
        var result = underTest.transformEntity(kundeEntity);

        // then
        assertThat(result.getId()).isEqualTo(111);
        assertThat(result.getFirstName()).isEqualTo("John");
        assertThat(result.getLastName()).isEqualTo("Doe");
        assertThat(result.getGeburtsDatum()).isEqualTo(Local_Date);
        assertThat(result.getTermine()).hasSize(1);
    }


}
