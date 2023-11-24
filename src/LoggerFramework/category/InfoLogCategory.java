package LoggerFramework.category;

import LoggerFramework.model.Log;
import LoggerFramework.model.LogType;
import LoggerFramework.sink.LogSink;

import java.util.List;
import java.util.Objects;

public class InfoLogCategory implements LogCategory {
    private final LogCategory nextLogCategory;
    private final List<LogSink> logSinkList;
    private final LogType logType;

    public InfoLogCategory(LogCategory logCategory, List<LogSink> logSinkList) {
        this.nextLogCategory = logCategory;
        this.logSinkList = logSinkList;
        this.logType = LogType.INFO;
    }

    @Override
    public void log(Log log) {
        if (Objects.equals(log.getLogType(), logType)) {
            for (LogSink sink : logSinkList) {
                sink.sendLog(log);
            }
        } else {
            nextLogCategory.log(log);
        }
    }
}
