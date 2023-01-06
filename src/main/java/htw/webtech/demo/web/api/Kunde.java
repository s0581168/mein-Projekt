package htw.webtech.demo.web.api;


import java.sql.Date;

public class Kunde {

    private long id;
    private String firstName;
    private String lastName;

    private Date geburtsDatum;

    private Integer telefonnummer;

    public Kunde(long id, String firstName, String lastName, Date geburtsDatum, Integer telefonnummer) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.geburtsDatum = geburtsDatum;
        this.telefonnummer = telefonnummer;
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
}
