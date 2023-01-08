package htw.webtech.demo.web.api;

import java.time.LocalDate;

public class TerminManipulationRequest {

    private LocalDate termindate;
    private Long ownerId;

    public TerminManipulationRequest(LocalDate termindate, Long ownerId) {
        this.termindate = termindate;
        this.ownerId = ownerId;
    }

    public TerminManipulationRequest() {}

    public LocalDate getTermindate() {
        return termindate;
    }

    public void setTermindate(LocalDate termindate) {
        this.termindate = termindate;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
