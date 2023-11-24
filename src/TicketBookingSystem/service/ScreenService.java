package TicketBookingSystem.service;

import TicketBookingSystem.model.Screen;
import TicketBookingSystem.util.Utils;

import java.util.Map;
import java.util.UUID;

public class ScreenService {

    private final Map<String, Screen> screens;
    public ScreenService(Map<String, Screen> screens) {
        this.screens = screens;
    }

    public Screen createScreen(final String screenName) {
        String screenId = Utils.getRandomUUID();
        Screen screen = new Screen(screenId, screenName);
        screens.put(screenId, screen);
        return screen;
    }

    public Screen getScreen(final String screenId) {
        return screens.get(screenId);
    }
}
