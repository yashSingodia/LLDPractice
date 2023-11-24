package TicketBookingSystem.service;

import TicketBookingSystem.model.Screen;
import TicketBookingSystem.model.Seat;
import TicketBookingSystem.model.Theatre;
import TicketBookingSystem.util.Utils;

import java.util.HashMap;
import java.util.Map;

public class TheatreService {

    private final Map<String, Theatre> theatres;
    private final Map<String, Screen> screens;
    private final Map<String, Seat> seats;

    public TheatreService() {
        this.theatres = new HashMap<>();
        this.screens = new HashMap<>();
        this.seats = new HashMap<>();
    }

    public Theatre addTheatre(String theatreName) {
        String theatreId = Utils.getRandomUUID();
        Theatre theatre = new Theatre(theatreId, theatreName);
        theatres.put(theatreId, theatre);
        return theatre;
    }

    public Screen addScreensInTheatre(String screenName, Theatre theatre) {
        String screenId = Utils.getRandomUUID();
        Screen screen = new Screen(screenId, screenName);
        theatre.addScreen(screen);
        screens.put(screenId, screen);
        return screen;
    }

    public Seat addSeatsInScreen(int rowNo, int seatNo, Screen screen) {
        String seatId = Utils.getRandomUUID();
        Seat seat = new Seat(seatId, rowNo, seatNo);
        screen.addSeats(seat);
        seats.put(seatId, seat);
        return seat;
    }

    public Theatre getTheatre(String theatreId) {
        if (!theatres.containsKey(theatreId)) {
            throw new RuntimeException();
        }
        return theatres.get(theatreId);
    }
    public Screen getScreen(String screenId) {
        if (!screens.containsKey(screenId)) {
            throw new RuntimeException();
        }
        return screens.get(screenId);
    }
    public Seat getSeat(String seatId) {
        if (!seats.containsKey(seatId)) {
            throw new RuntimeException();
        }
        return seats.get(seatId);
    }
}
