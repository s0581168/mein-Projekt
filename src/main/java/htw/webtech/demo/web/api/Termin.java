package htw.webtech.demo.web.api;

import java.time.LocalDate;

public class Termin {

    private Long id;
    private LocalDate termindate;

    private Kunde kunde;

    public Termin(Long id, LocalDate termindate, Kunde kunde) {
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

    public LocalDate getTermindate() {
        return termindate;
    }

    public void setTermindate(LocalDate termindate) {
        this.termindate = termindate;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
