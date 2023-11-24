package LoggerFramework.sink;

import LoggerFramework.model.Log;

public interface LogSink {
    void sendLog(Log log);
}
