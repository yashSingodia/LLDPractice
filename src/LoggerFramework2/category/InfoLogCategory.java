package LoggerFramework2.category;

import LoggerFramework2.observer.LoggerObserver;

public class InfoLogCategory extends LogCategory {

    public InfoLogCategory(int level) {
        this.level = level;
    }

    @Override
    protected void display(int level, String message, LoggerObserver loggerObserver) {
        loggerObserver.notifyAllObservers(level, message);
    }
}
