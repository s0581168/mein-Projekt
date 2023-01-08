package htw.webtech.demo.web.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class TerminManipulationRequest {

    private LocalDateTime termindate;

    private Long ownerId;

    public TerminManipulationRequest(LocalDateTime termindate, Long ownerId) {
        this.termindate = termindate;
        this.ownerId = ownerId;
    }

    public TerminManipulationRequest() {}

    public LocalDateTime getTermindate() {
        return termindate;
    }

    public void setTermindate(LocalDateTime termindate) {
        this.termindate = termindate;
    }
    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
