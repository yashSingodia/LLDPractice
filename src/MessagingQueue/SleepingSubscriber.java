package MessagingQueue;

import MessagingQueue.model.Message;

public class SleepingSubscriber implements ISubscriber{
    private final String id;
    private final int sleepTime;

    public SleepingSubscriber(String id, int sleepTime) {
        this.id = id;
        this.sleepTime = sleepTime;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void consumeMessage(Message message) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
