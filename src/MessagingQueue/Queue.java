package MessagingQueue;

import MessagingQueue.exceptions.TopicNotFoundException;
import MessagingQueue.model.Message;
import MessagingQueue.model.Topic;
import MessagingQueue.model.TopicSubscriber;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Queue {
    private Map<String, TopicHandler> topicHandlers;

    // create topic
    public Topic createTopic(String topicName) {
        Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler topicHandler = new TopicHandler(topic);
        topicHandlers.put(topic.getTopicId(), topicHandler);
        return topic;
    }

    // subscribe
    public void addSubscriber( ISubscriber iSubscriber, Topic topic) {
        topic.addSubscriber(new TopicSubscriber(iSubscriber));
    }

    // produce message
    public void publish(Topic topic, Message message) {
        topic.addMessage(message);

        System.out.println(message + " published to topic: " + topic.getName());

        if (topicHandlers.containsKey(topic.getTopicId())) {
            new Thread( () -> {
                Thread.currentThread().setName("Producer");
                topicHandlers.get(topic.getTopicId()).publish();
            }).start();
        } else {
            throw new TopicNotFoundException("Topic Not Found");
        }
    }

    // reset offset of the sub
    public void resetOffset(Topic topic, ISubscriber iSubscriber, Integer newOffset) {
        for (TopicSubscriber topicSubscriber : topic.getSubscriberList()) {
            if (topicSubscriber.getSubscriber().equals(iSubscriber)) {
                topicSubscriber.getOffset().set(newOffset);
                new Thread(() -> {
                    topicHandlers.get(topic.getTopicId()).startSubscriberWorker(topicSubscriber);
                }).start();
            }

        }
    }
}
