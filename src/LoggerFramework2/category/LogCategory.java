package LoggerFramework2.category;

import LoggerFramework2.observer.LoggerObserver;

public abstract class LogCategory {

    protected int level;
    private LogCategory nextLogCategory;

    public void setNextLogCategory(LogCategory nextLogCategory) {
        this.nextLogCategory = nextLogCategory;
    }

    public void logMessage(int level, String message, LoggerObserver loggerObserver) {
        if (this.level <= level) {
            display(level, message, loggerObserver);
        }
        if (nextLogCategory != null) {
            nextLogCategory.logMessage(level, message, loggerObserver);
        }
    }

    protected abstract void display(int level, String message, LoggerObserver loggerObserver);
}
