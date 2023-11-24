package MessagingQueue.model;

import MessagingQueue.ISubscriber;

import java.util.concurrent.atomic.AtomicInteger;

public class TopicSubscriber {
    private AtomicInteger offset;
    private ISubscriber subscriber;

    public TopicSubscriber(ISubscriber subscriber) {
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }

    public AtomicInteger getOffset() {
        return offset;
    }

    public ISubscriber getSubscriber() {
        return subscriber;
    }
}
