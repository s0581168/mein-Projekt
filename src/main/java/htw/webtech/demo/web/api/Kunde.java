package htw.webtech.demo.web.api;


import java.sql.Date;
import java.util.List;

public class Kunde {

    private long id;
    private String firstName;
    private String lastName;

    private Date geburtsDatum;

    private Integer telefonnummer;

    private List<Long> termine;

    public Kunde(long id, String firstName, String lastName, Date geburtsDatum, Integer telefonnummer, List<Long> termine) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.geburtsDatum = geburtsDatum;
        this.telefonnummer = telefonnummer;
        this.termine = termine;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Integer getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(Integer telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public List<Long> getTermine() {
        return termine;
    }

    public void setTermine(List<Long> termine) {
        this.termine = termine;
    }
}
