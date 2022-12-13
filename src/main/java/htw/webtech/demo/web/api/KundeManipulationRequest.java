package htw.webtech.demo.web.api;

import java.sql.Date;

public class KundeManipulationRequest {
    private String firstName;
    private String lastName;

    private Date geburtsDatum;

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
