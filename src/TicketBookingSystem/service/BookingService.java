package TicketBookingSystem.service;

import TicketBookingSystem.model.Booking;
import TicketBookingSystem.model.Seat;
import TicketBookingSystem.model.Show;
import TicketBookingSystem.provider.SeatLockProvider;
import TicketBookingSystem.util.Utils;

import java.util.*;
import java.util.stream.Collectors;

public class BookingService {
    private final Map<String, Booking> bookings;
    private final SeatLockProvider seatLockProvider;

    public BookingService(SeatLockProvider seatLockProvider) {
        this.bookings = new HashMap<>();
        this.seatLockProvider = seatLockProvider;
    }

    public Booking createBooking(String userId, Show show, List<Seat> seatList) {

        if (isAnyBookingAlreadyPresent(show, seatList)) {
            throw new RuntimeException();
        }
        seatLockProvider.lockSeats(show, userId, seatList);
        String bookingId = Utils.getRandomUUID();
        Booking booking = new Booking(bookingId, show, seatList, userId);
        bookings.put(bookingId, booking);
        return booking;
    }

    private boolean isAnyBookingAlreadyPresent(Show show, List<Seat> seatList) {
        List<Seat> bookedSeats = getBookedSeats(show);
        for (Seat seat : seatList) {
            if (bookedSeats.contains(seat)) {
                return true;
            }
        }
        return false;
    }

    public List<Seat> getBookedSeats(Show show) {
        return getAllBookings(show)
                .stream()
                .filter(Booking::isConfirmed)
                .map(Booking::getBookedSeats)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<Booking> getAllBookings(Show show) {
        List<Booking> response = new ArrayList<>();
        for (Booking booking : bookings.values()) {
            if (booking.getShow().equals(show)) {
                response.add(booking);
            }
        }
        return response;

    }
}
