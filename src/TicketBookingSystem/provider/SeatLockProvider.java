package TicketBookingSystem.provider;

import TicketBookingSystem.model.Seat;
import TicketBookingSystem.model.Show;

import java.util.List;

public interface SeatLockProvider {
    void lockSeats(Show show, String user, List<Seat> seats);
    void unlockSeats(Show show, String user, List<Seat> seats);

    boolean validateLock(Show show, String user, Seat seat);

    List<Seat> getLockedSeat(Show show);
}
