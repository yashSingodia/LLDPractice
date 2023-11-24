package LoggerFramework;

import LoggerFramework.category.DebugLogCategory;
import LoggerFramework.category.ErrorLogCategory;
import LoggerFramework.category.InfoLogCategory;
import LoggerFramework.category.NullLogCategory;
import LoggerFramework.model.Log;
import LoggerFramework.model.LogType;
import LoggerFramework.service.Logger;
import LoggerFramework.service.impl.LoggerServiceImpl;
import LoggerFramework.sink.LogSink;
import LoggerFramework.sink.impl.ConsoleLogSink;

import java.util.ArrayList;
import java.util.List;

public class LogMain {

    public static void main(String[] args) {

        Log log = new Log("Hey, I am a log", LogType.ERROR);

        List<LogSink> logSinkList = new ArrayList<>();
        logSinkList.add(new ConsoleLogSink());

        NullLogCategory nullLogCategory = new NullLogCategory();
        ErrorLogCategory errorLogCategory = new ErrorLogCategory(nullLogCategory, logSinkList);
        DebugLogCategory debugLogCategory = new DebugLogCategory(errorLogCategory, logSinkList);
        InfoLogCategory infoLogCategory = new InfoLogCategory(debugLogCategory, logSinkList);

        Logger logger = new LoggerServiceImpl(infoLogCategory);
        logger.addLog(log);

    }
}
