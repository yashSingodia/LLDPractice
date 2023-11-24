package TicketBookingSystem.provider;

import TicketBookingSystem.model.Seat;
import TicketBookingSystem.model.SeatLock;
import TicketBookingSystem.model.Show;
import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.*;

public class InmemoryLockProvider implements SeatLockProvider{

    private final Integer lockTimeout;
    private final Map<Show, Map<Seat, SeatLock>> locks;

    public InmemoryLockProvider(Integer lockTimeout, Map<Show, Map<Seat, SeatLock>> lockSeat) {
        this.lockTimeout = lockTimeout;
        this.locks = lockSeat;
    }


    @Override
    synchronized public void lockSeats(Show show, String user, List<Seat> seats) {

        for (Seat seat : seats) {
            if (isSeatLocked(seat, show)) {
                throw new RuntimeException();
            }
        }

        for (Seat seat : seats) {
            lockSeat(show, seat, user, lockTimeout);
        }
    }

    private boolean isSeatLocked(Seat seat, Show show) {
        return locks.containsKey(show) && locks.get(show).containsKey(seat) && !locks.get(show).get(seat).isLockExpired();
    }

    private void lockSeat(Show show, Seat seat, String user, Integer lockTimeout) {
        if (!locks.containsKey(show)) {
            locks.put(show, new HashMap<>());
        }
        SeatLock seatLock = new SeatLock(seat, show, lockTimeout, user, new Date());
        locks.get(show).put(seat, seatLock);
    }

    @Override
    public void unlockSeats(Show show, String user, List<Seat> seats) {
        for (Seat seat : seats) {
            if (validateLock(show, user, seat)) {
                locks.get(show).remove(seat);
            }
        }
    }

    @Override
    public boolean validateLock(Show show, String user, Seat seat) {
        return isSeatLocked(seat, show) && locks.get(show).get(seat).getLockedBy().equals(user);
    }

    @Override
    public List<Seat> getLockedSeat(Show show) {
        if (!locks.containsKey(show)) {
            return new ArrayList<>();
        }
        List<Seat> lockedSeats = new ArrayList<>();
        for (Seat seat : locks.get(show).keySet()) {
            if (isSeatLocked(seat, show)) {
                lockedSeats.add(seat);
            }
        }
        return lockedSeats;
    }
}
