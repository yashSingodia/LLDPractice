package MessagingQueue;

import MessagingQueue.model.Message;
import MessagingQueue.model.Topic;
import MessagingQueue.model.TopicSubscriber;

public class SubscriberWorker implements Runnable{
    private Topic topic;
    private final TopicSubscriber topicSubscriber;

    public SubscriberWorker(Topic topic, TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    @Override
    public void run() {
        synchronized (topicSubscriber) {
            do {
                int currOffset = topicSubscriber.getOffset().get();
                while (currOffset >= topic.getMessagesList().size()) {
                    try {
                        topicSubscriber.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Message message = topic.getMessagesList().get(currOffset);
                topicSubscriber.getSubscriber().consumeMessage(message);
                topicSubscriber.getOffset().compareAndSet(currOffset, currOffset + 1);

            } while (true);
        }
    }

    public void wakeupIfNeeded() {
        synchronized (topicSubscriber) {
            topicSubscriber.notify();
        }
    }


}
