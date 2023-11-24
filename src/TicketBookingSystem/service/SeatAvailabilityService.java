package TicketBookingSystem.service;

import TicketBookingSystem.model.Seat;
import TicketBookingSystem.model.Show;

import java.util.List;

public class SeatAvailabilityService {
    private final BookingService bookingService;

    public SeatAvailabilityService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public List<Seat> getAvailableSeats(Show show) {
        List<Seat> totalSeats = show.getScreen().getSeats();
        List<Seat> unavailableSeats = getUnavailableSeats(show);
        totalSeats.removeAll(unavailableSeats);
        return totalSeats;
    }

    private List<Seat> getUnavailableSeats(Show show) {
//        List<Seat> unavailableSeats = ;
//        unavailableSeats.addAll();
//        return unavailableSeats;
        return null;
    }
}
