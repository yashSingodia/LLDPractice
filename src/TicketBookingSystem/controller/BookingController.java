package TicketBookingSystem.controller;

import TicketBookingSystem.model.Seat;
import TicketBookingSystem.model.Show;
import TicketBookingSystem.service.BookingService;
import TicketBookingSystem.service.ShowService;
import TicketBookingSystem.service.TheatreService;

import java.util.List;
import java.util.stream.Collectors;

public class BookingController {
    private final ShowService showService;
    private final TheatreService theatreService;
    private final BookingService bookingService;

    public BookingController(ShowService showService, TheatreService theatreService, BookingService bookingService) {
        this.showService = showService;
        this.theatreService = theatreService;
        this.bookingService = bookingService;
    }

    public String createBooking(final String userId, final String showId, final List<String> seatIds) {
        Show show = showService.getShow(showId);
        List<Seat> seatList = seatIds.stream().map(theatreService::getSeat).collect(Collectors.toList());
        return bookingService.createBooking(userId, show, seatList).getBookingId();
    }
}
