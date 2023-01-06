package htw.webtech.demo.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.*;
import java.sql.Date;

@Entity(name ="kunde")
public class KundeEnity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "geburt_datum")
    private Date geburtsDatum;

    @Column(name = "telefonnummer")
    private Integer telefonnummer;


    public KundeEnity(String firstName, String lastName, Date geburtsDatum, Integer telefonnummer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.geburtsDatum = geburtsDatum;
        this.telefonnummer = telefonnummer;
    }

    protected KundeEnity(){}

    public Long getId() {
        return id;
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
