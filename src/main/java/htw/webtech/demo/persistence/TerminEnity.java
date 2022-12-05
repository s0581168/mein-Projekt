package htw.webtech.demo.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name ="Termin")
public class TerminEnity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patient")
    private boolean patient;

    @Column(name = "Telefonnummer")
    private Integer Telefonnummer;

    @Column(name = "termin")
    private LocalDate termin;


    public TerminEnity(String lastName, boolean patient, Integer telefonnummer, LocalDate termin) {
        this.lastName = lastName;
        this.patient = patient;
        this.Telefonnummer = telefonnummer;
        this.termin = termin;
    }

    protected TerminEnity(){}

    public Long getId() {
        return id;
    }

    public boolean isPatient() {
        return patient;
    }

    public void setPatient(boolean patient) {
        this.patient = patient;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getTelefonnummer() {
        return Telefonnummer;
    }

    public void setTelefonnummer(Integer telefonnummer) {
        Telefonnummer = telefonnummer;
    }

    public LocalDate getTermin() {
        return termin;
    }

    public void setTermin(LocalDate termin) {
        this.termin = termin;
    }
}
