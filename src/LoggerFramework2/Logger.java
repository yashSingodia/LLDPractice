package LoggerFramework2;

import LoggerFramework2.category.LogCategory;
import LoggerFramework2.observer.LoggerObserver;

import java.util.Objects;

import static LoggerFramework2.LogManager.addObservers;
import static LoggerFramework2.LogManager.doChaining;

public class Logger {
    private static volatile Logger logger;
    private static volatile LoggerObserver loggerObserver;
    private static volatile LogCategory logCategory;
    private Logger() {

    }
    public static Logger getLogger() {
        if (Objects.isNull(logger)) {
            synchronized (Logger.class) {
                if (Objects.isNull(logger)) {
                    logger = new Logger();
                    logCategory = doChaining();
                    loggerObserver = addObservers();
                    return logger;
                }
            }
        }
        return logger;
    }

    public void info(String message) {
        createLog(1, message);
    }

    public void error(String message) {
        createLog(2, message);
    }

    public void debug(String message) {
        createLog(3, message);
    }

    private void createLog(int level, String message) {
        logCategory.logMessage(level, message, loggerObserver);
    }
}
