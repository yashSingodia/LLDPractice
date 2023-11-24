package TicketBookingSystem.controller;

import TicketBookingSystem.model.Movie;
import TicketBookingSystem.model.Screen;
import TicketBookingSystem.model.Seat;
import TicketBookingSystem.model.Show;
import TicketBookingSystem.service.MovieService;
import TicketBookingSystem.service.ScreenService;
import TicketBookingSystem.service.SeatAvailabilityService;
import TicketBookingSystem.service.ShowService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ShowController {
    private final ShowService showService;
    private final MovieService movieService;
    private final ScreenService screenService;

    private final SeatAvailabilityService seatAvailabilityService;

    public ShowController(ShowService showService, MovieService movieService, ScreenService screenService, SeatAvailabilityService seatAvailabilityService) {
        this.showService = showService;
        this.movieService = movieService;
        this.screenService = screenService;
        this.seatAvailabilityService = seatAvailabilityService;
    }

    public String createShow(final String movieId, final String screenId, final Integer duration, final Date startTime) {
        Movie movie = movieService.getMovie(movieId);
        Screen screen = screenService.getScreen(screenId);
        return showService.createShow(movie, screen, duration, startTime).getId();
    }

    public List<String> getAvailableSeats(final String showId) {
        final Show show = showService.getShow(showId);
        List<Seat> availableSeats = seatAvailabilityService.getAvailableSeats(show);
        return availableSeats.stream().map(Seat::getSeatId).collect(Collectors.toList());
    }

}
