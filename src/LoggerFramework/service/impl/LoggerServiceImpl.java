package LoggerFramework.service.impl;

import LoggerFramework.category.LogCategory;
import LoggerFramework.model.Log;
import LoggerFramework.service.Logger;

public class LoggerServiceImpl implements Logger {
    private final LogCategory logCategory;

    public LoggerServiceImpl(LogCategory logCategory) {
        this.logCategory = logCategory;
    }


    @Override
    public boolean addLog(Log log) {
        logCategory.log(log);
        return true;
    }
}
