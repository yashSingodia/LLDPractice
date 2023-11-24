package TicketBookingSystem.model;

import java.time.Instant;
import java.util.Date;

public class SeatLock {
    private final Seat seat;
    private final Show show;
    private final Integer timeoutInSeconds;
    private final String lockedBy;
    private final Date lockTime;

    public SeatLock(Seat seat, Show show, Integer timeoutInSeconds, String lockedBy, Date lockTime) {
        this.seat = seat;
        this.show = show;
        this.timeoutInSeconds = timeoutInSeconds;
        this.lockedBy = lockedBy;
        this.lockTime = lockTime;
    }

    public boolean isLockExpired() {
        Instant lockInstance = lockTime.toInstant().plusSeconds(timeoutInSeconds);
        Instant currentInstance = new Date().toInstant();
        return lockInstance.isBefore(currentInstance);
    }

    public Seat getSeat() {
        return seat;
    }

    public Show getShow() {
        return show;
    }

    public Integer getTimeoutInSeconds() {
        return timeoutInSeconds;
    }

    public String getLockedBy() {
        return lockedBy;
    }

    public Date getLockTime() {
        return lockTime;
    }
}
