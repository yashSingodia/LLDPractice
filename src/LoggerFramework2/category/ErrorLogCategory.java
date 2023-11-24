package LoggerFramework2.category;

import LoggerFramework2.observer.LoggerObserver;

public class ErrorLogCategory extends LogCategory {
    public ErrorLogCategory(int level) {
        this.level = level;
    }

    @Override
    protected void display(int level, String message, LoggerObserver loggerObserver) {
        loggerObserver.notifyAllObservers(level, message);
    }
}
