package TicketBookingSystem.controller;

import TicketBookingSystem.model.Screen;
import TicketBookingSystem.model.Theatre;
import TicketBookingSystem.service.TheatreService;

public class TheatreController {
    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    public String createTheatre(final String theatreName) {
        return theatreService.addTheatre(theatreName).getId();
    }

    public String addScreensInTheatre(final String screenName, Theatre theatre) {
        return theatreService.addScreensInTheatre(screenName, theatre).getScreenId();
    }

    public String addSeatsInScreen(final int rowNo, int seatNo, Screen screen) {
        return theatreService.addSeatsInScreen(rowNo, seatNo, screen).getSeatId();
    }
}
