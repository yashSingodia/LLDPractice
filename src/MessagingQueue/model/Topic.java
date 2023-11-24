package MessagingQueue.model;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private String topicId;
    private String name;

    private List<Message> messagesList;

    private List<TopicSubscriber> subscriberList;

    public Topic(String topicId, String name) {
        this.topicId = topicId;
        this.name = name;
        this.messagesList = new ArrayList<>();
        this.subscriberList = new ArrayList<>();
    }

    public synchronized void addMessage(Message message) {
        messagesList.add(message);
    }

    public void addSubscriber(TopicSubscriber topicSubscriber) {
        subscriberList.add(topicSubscriber);
    }

    public String getTopicId() {
        return topicId;
    }

    public String getName() {
        return name;
    }

    public List<TopicSubscriber> getSubscriberList() {
        return subscriberList;
    }

    public List<Message> getMessagesList() {
        return messagesList;
    }

}
