package LoggerFramework2;

import LoggerFramework2.category.DebugLogCategory;
import LoggerFramework2.category.ErrorLogCategory;
import LoggerFramework2.category.InfoLogCategory;
import LoggerFramework2.category.LogCategory;
import LoggerFramework2.observer.ConsoleSinkObserver;
import LoggerFramework2.observer.FileSinkObserver;
import LoggerFramework2.observer.LoggerObserver;

public class LogManager {

    public static LogCategory doChaining() {
        LogCategory infoLogCategory = new InfoLogCategory(1);
        LogCategory errrorLogCategory = new ErrorLogCategory(2);
        LogCategory debugLogCategory = new DebugLogCategory(3);

        infoLogCategory.setNextLogCategory(errrorLogCategory);
        errrorLogCategory.setNextLogCategory(debugLogCategory);

        return infoLogCategory;
    }

    public static LoggerObserver addObservers() {
        LoggerObserver loggerObserver = new LoggerObserver();
        loggerObserver.addObserver(1, new ConsoleSinkObserver());
        loggerObserver.addObserver(1, new FileSinkObserver());


        loggerObserver.addObserver(2, new ConsoleSinkObserver());
        loggerObserver.addObserver(3, new ConsoleSinkObserver());
        return loggerObserver;
    }
}
