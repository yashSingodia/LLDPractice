package TicketBookingSystem.service;

import TicketBookingSystem.model.Movie;
import TicketBookingSystem.model.Screen;
import TicketBookingSystem.model.Show;
import TicketBookingSystem.util.Utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ShowService {
    private final Map<String, Show> shows;
    public ShowService() {
        this.shows = new HashMap<>();
    }

    public Show createShow(final Movie movie, final Screen screen, final Integer durationInSeconds, final Date startTime) {
        String showId = Utils.getRandomUUID();
        Show show = new Show(showId, movie, screen, startTime, durationInSeconds);
        shows.put(showId, show);
        return show;
    }

    public Show getShow(final String showId) {
        return shows.get(showId);
    }
}
