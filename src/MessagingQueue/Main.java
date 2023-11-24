package MessagingQueue;

import MessagingQueue.model.Message;
import MessagingQueue.model.Topic;

public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue();
        Topic t1 = queue.createTopic("t1");
        SleepingSubscriber sleepingSubscriber = new SleepingSubscriber("s1", 2000);

        queue.addSubscriber(sleepingSubscriber, t1);
        queue.publish(t1, new Message("m1", "m1"));
        queue.publish(t1, new Message("m1", "m2"));


    }
}
