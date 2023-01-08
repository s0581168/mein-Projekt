package web;

import htw.webtech.demo.MeinProjektApplication;
import htw.webtech.demo.web.api.Kunde;
import htw.webtech.demo.web.api.KundeRestController;
import htw.webtech.demo.web.service.KundeService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= MeinProjektApplication.class)
@WebMvcTest(KundeRestController.class)
public class KundeRestcontrollerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KundeService kundeService;

    @Test
    @DisplayName("should return found kunden from kunde service")
    void should_return_found_kunde_from_kunde_service() throws Exception {
        // given
        var kunden = List.of(
                new Kunde(1, "John", "Doe", LocalDate.of(1997,02,25), 123456, Collections.emptyList()),
                new Kunde(2, "Maria", "Thompson", LocalDate.of(1998,01,23), 234567, Collections.emptyList())
        );
        doReturn(kunden).when(kundeService).findAll();

        // when
        mockMvc.perform(get("/api/v1/kunde_verwaltung"))
                // then
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Doe"))
                .andExpect(jsonPath("$[0].geburtsDatum").value(LocalDate.of(1997,02,25)))
                .andExpect(jsonPath("$[0].telefonnummer").value(123456))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].firstName").value("Maria"))
                .andExpect(jsonPath("$[1].lastName").value("Thompson"))
                .andExpect(jsonPath("$[1].geburtsDatum").value(LocalDate.of(1998,01,23)))
                .andExpect(jsonPath("$[1].telefonnummer").value(234567));
    }

    @Test
    @DisplayName("should return 404 if kunde is not found")
    void should_return_404_if_person_is_not_found() throws Exception {
        // given
        doReturn(null).when(kundeService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/kunde_verwaltung/123"))
                // then
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating a person")
    void should_return_201_http_status_and_location_header_when_creating_a_kunde() throws Exception {
        // given
        String kundeToCreateAsJson = "{\"firstName\": \"John\", \"lastName\":\"Doe\", \"geburtsdatum\":\"1997-02-25\", \"telefonnummer\": 123456}";
        var kunde = new Kunde(123, null, null, null, null, null);
        doReturn(kunde).when(kundeService).create(any());

        // when
        mockMvc.perform(
                        post("/api/v1/kunde_verwaltung")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(kundeToCreateAsJson)
                )
                // then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/kunde_verwaltung/" + kunde.getId()))));
//            .andExpect(header().string("Location", Matchers.containsString(Long.toString(kunde.getId()))));

    }

    @Test
    @DisplayName("should validate create kunde request")
    void should_validate_create_kunde_request() throws Exception {
        // given
        String kundeToCreateAsJson = "{\"firstName\": \"a\", \"lastName\":\"\", \"geburtsDatum\":\"1997-02-24\", \"telefonnummer\": 123}";

        // when
        mockMvc.perform(
                        post("/api/v1/kunde_verwaltung")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(kundeToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());
    }
}

