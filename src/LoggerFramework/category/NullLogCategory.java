package LoggerFramework.category;

import LoggerFramework.model.Log;

public class NullLogCategory implements LogCategory{
    @Override
    public void log(Log log) {
    }
}
