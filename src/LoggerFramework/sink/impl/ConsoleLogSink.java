package LoggerFramework.sink.impl;

import LoggerFramework.model.Log;
import LoggerFramework.sink.LogSink;

public class ConsoleLogSink implements LogSink {
    @Override
    public void sendLog(Log log) {
        System.out.println("LogType: " + log.getLogType() + " LogId: " + log.getLogId() + " Message: " + log.getMessage());
    }
}
