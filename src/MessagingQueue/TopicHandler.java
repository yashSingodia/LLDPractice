package MessagingQueue;

import MessagingQueue.model.Topic;
import MessagingQueue.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TopicHandler {
    private Topic topic;
    private final Map<String, SubscriberWorker> subscriberWorkers;

    public TopicHandler(Topic topic) {
        this.topic = topic;
        this.subscriberWorkers = new HashMap<>();
    }

    public void publish() {
        System.out.println("Inside publish method of thread " + Thread.currentThread().getName());
        for (TopicSubscriber topicSubscriber : topic.getSubscriberList()) {
            startSubscriberWorker(topicSubscriber);
        }
    }

    public void startSubscriberWorker(TopicSubscriber topicSubscriber) {
        String subscriberId = topicSubscriber.getSubscriber().getId();
        if (!subscriberWorkers.containsKey(subscriberId)) {
            SubscriberWorker subscriberWorker = new SubscriberWorker(topic, topicSubscriber);
            subscriberWorkers.put(subscriberId, subscriberWorker);
            new Thread(subscriberWorker).start();
        }
        SubscriberWorker subscriberWorker = subscriberWorkers.get(subscriberId);
        subscriberWorker.wakeupIfNeeded();
    }
}
