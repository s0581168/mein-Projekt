package htw.webtech.demo.persistence;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "termine")
public class TerminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private LocalDate termindate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private KundeEnity owner;

    public TerminEntity(){
    }

    public TerminEntity(LocalDate termindate, KundeEnity owner) {
        this.termindate = termindate;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getTermindate() {
        return termindate;
    }

    public void setTermindate(LocalDate termindate) {
        this.termindate = termindate;
    }

    public KundeEnity getOwner() {
        return owner;
    }

    public void setOwner(KundeEnity owner) {
        this.owner = owner;
    }
}
