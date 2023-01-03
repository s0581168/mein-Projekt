package htw.webtech.demo.web.api;

import javax.validation.constraints.*;
import java.sql.Date;

public class KundeManipulationRequest {
    @Size(min = 3, message = "Please provide a first name with 3 characters or more.")
    private String firstName;

    @NotBlank(message = "The last name must not be empty.")
    private String lastName;


    @Past(message = "the geburtsdatum must to be the past.")
    private Date geburtsDatum;


    @Email(message = "The e-mail must be in e-mail form.")
    private String eMail;


    public KundeManipulationRequest(String firstName, String lastName, Date geburtsDatum, String eMail) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.geburtsDatum = geburtsDatum;
        this.eMail = eMail;
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

    public Date getGeburtsDatum() {
        return geburtsDatum;
    }

    public void setGeburtsDatum(Date geburtsDatum) {
        this.geburtsDatum = geburtsDatum;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
