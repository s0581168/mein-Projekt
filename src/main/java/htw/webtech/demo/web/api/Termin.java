package htw.webtech.demo.web.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Timer;
import java.sql.Time;

public class Termin {

    private Long id;
    private LocalDateTime termindate;


    private Kunde kunde;

    public Termin(Long id, LocalDateTime termindate, Kunde kunde) {
        this.id = id;
        this.termindate = termindate;
        this.kunde = kunde;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTermindate() {
        return termindate;
    }

    public void setTermindate(LocalDateTime termindate) {
        this.termindate = termindate;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
