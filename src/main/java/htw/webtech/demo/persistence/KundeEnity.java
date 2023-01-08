package htw.webtech.demo.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private LocalDate geburtsDatum;

    @Column(name = "telefonnummer")
    private Integer telefonnummer;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<TerminEntity> termine = new ArrayList<>();


    public KundeEnity(String firstName, String lastName, LocalDate geburtsDatum, Integer telefonnummer) {
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

    public LocalDate getGeburtsDatum() {
        return geburtsDatum;
    }

    public void setGeburtsDatum(LocalDate geburtsDatum) {
        this.geburtsDatum = geburtsDatum;
    }

    public Integer getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(Integer telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public List<TerminEntity> getTermine() {
        return termine;
    }

    public void setTermine(List<TerminEntity> termine) {
        this.termine = termine;
    }
}
