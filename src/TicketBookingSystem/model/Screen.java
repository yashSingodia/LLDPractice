package TicketBookingSystem.model;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private final String screenId;
    private final String screenName;
    private final List<Seat> seats;

    public Screen(String screenId, String screenName) {
        this.screenId = screenId;
        this.screenName = screenName;
        this.seats = new ArrayList<>();
    }

    public void addSeats(Seat seat) {
        seats.add(seat);
    }

    public String getScreenId() {
        return screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public List<Seat> getBookedSeats() {
//        return seats.stream().map()
        return null;
    }
}
