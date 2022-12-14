package htw.webtech.demo.web.api;

import javax.validation.constraints.*;
import java.sql.Date;
import java.time.LocalDate;

public class KundeManipulationRequest {
    @Size(min = 3 , message = "Please provide a first name with 3 characters or more.")
    private String firstName;

    @NotBlank(message = "The last name must not be empty.")
    private String lastName;


    @Past(message = "the geburtsdatum must to be the past.")
    private LocalDate geburtsDatum;



    private Integer telefonnumer;


    public KundeManipulationRequest(String firstName, String lastName, LocalDate geburtsDatum, Integer telefonnumer) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.geburtsDatum = geburtsDatum;
        this.telefonnumer = telefonnumer;
    }

    public KundeManipulationRequest(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getGeburtsDatum() {
        return geburtsDatum;
    }

    public void setGeburtsDatum(LocalDate geburtsDatum) {
        this.geburtsDatum = geburtsDatum;
    }

    public Integer getTelefonnumer() {
        return telefonnumer;
    }

    public void setTelefonnumer(Integer telefonnumer) {
        this.telefonnumer = telefonnumer;
    }
}
