package LoggerFramework2;

import LoggerFramework2.observer.LoggerObserver;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        logger.info("Hi, I am a info log");
//        logger.error("Hi, I am an error log");
//        logger.debug("Hi, I am an debug log");
    }
}
