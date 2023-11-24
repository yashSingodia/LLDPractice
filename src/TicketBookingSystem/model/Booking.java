package TicketBookingSystem.model;

import java.util.List;

public class Booking {
    private final String bookingId;
    private final Show show;
    private final List<Seat> bookedSeats;
    private BookingStatus bookingStatus;
    private final String userId;

    public Booking(String bookingId, Show show, List<Seat> bookedSeats, String userId) {
        this.bookingId = bookingId;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.bookingStatus = BookingStatus.CREATED;
        this.userId = userId;

    }

    public boolean isConfirmed() {
        return this.bookingStatus == BookingStatus.CONFIRMED;
    }
    public void confirmBooking() {
        if (this.bookingStatus != BookingStatus.CREATED) {
            throw new RuntimeException();
        }
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public void expireBooking() {
        if (this.bookingStatus != BookingStatus.CREATED) {
            throw new RuntimeException();
        }
        this.bookingStatus = BookingStatus.EXPIRED;
    }


    public String getBookingId() {
        return bookingId;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public String getUserId() {
        return userId;
    }
}
