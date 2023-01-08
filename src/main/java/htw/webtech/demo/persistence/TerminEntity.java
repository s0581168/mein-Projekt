package htw.webtech.demo.persistence;


import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;

@Entity(name = "termine")
public class TerminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private LocalDateTime termindate;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private KundeEnity owner;

    public TerminEntity(){
    }

    public TerminEntity(LocalDateTime termindate ,KundeEnity owner) {
        this.termindate = termindate;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTermindate() {
        return termindate;
    }

    public void setTermindate(LocalDateTime termindate) {
        this.termindate = termindate;
    }

    public KundeEnity getOwner() {
        return owner;
    }

    public void setOwner(KundeEnity owner) {
        this.owner = owner;
    }
}
