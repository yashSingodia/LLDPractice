package LoggerFramework2.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoggerObserver {

    private final Map<Integer, List<SinkObserver>> logObserverMap;

    public LoggerObserver() {
        this.logObserverMap = new HashMap<>();
    }

    public void addObserver(int level, SinkObserver sinkObserver) {
        List<SinkObserver> currentObserver = logObserverMap.getOrDefault(level, new ArrayList<>());
        currentObserver.add(sinkObserver);

        logObserverMap.put(level, currentObserver);
    }

    public void removeObserver(SinkObserver sinkObserver) {
        // remove observer from map
    }

    public void notifyAllObservers(int level, String message) {
        if (!logObserverMap.containsKey(level)) {
            throw new RuntimeException();
        }

        List<SinkObserver> sinkObservers = logObserverMap.get(level);
        sinkObservers.forEach(sinkObserver -> {sinkObserver.log(level, message);});

    }
}
