package MessagingQueue;

import MessagingQueue.model.Message;

public interface ISubscriber {
    public String getId();

    void consumeMessage(Message message);

}
