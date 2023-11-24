package LoggerFramework.model;

import LoggerFramework.utils.RandomUUIDGenerator;

public class Log {
    private final String logId;
    private final String message;
    private final LogType logType;

    public Log(String message, LogType logType) {
        this.logId = RandomUUIDGenerator.getRandomNumber();
        this.message = message;
        this.logType = logType;
    }

    public String getLogId() {
        return logId;
    }


    public String getMessage() {
        return message;
    }

    public LogType getLogType() {
        return logType;
    }
}
