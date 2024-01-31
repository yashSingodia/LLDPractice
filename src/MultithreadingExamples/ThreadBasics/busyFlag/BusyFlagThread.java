package ThreadBasics.busyFlag;

public class BusyFlagThread {

    protected Thread busyFlag;

    public void getBusyFlag() {
        while (busyFlag != Thread.currentThread()) {
            if(busyFlag == null) {
                busyFlag = Thread.currentThread();
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void freeBusyFlag() {
        if (busyFlag == Thread.currentThread()) {
            busyFlag = null;
        }
    }
}
