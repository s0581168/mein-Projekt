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

//@RunWith(SpringRunner.class)
@ContextConfiguration(classes= MeinProjektApplication.class)
@WebMvcTest(KundeRestController.class)
public class KundeRestcontrollerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KundeService kundeService;



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
