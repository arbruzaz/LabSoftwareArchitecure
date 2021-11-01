import java.util.ArrayList;
import java.util.concurrent.Flow;

public class StringPublisher implements Flow.Publisher<String> {

    private ArrayList<StringSubscriber> subscribers;
    private ArrayList<StringSubscription> subscriptions;

    public StringPublisher() {
        this.subscribers = new ArrayList<StringSubscriber>();
        this.subscriptions = new ArrayList<StringSubscription>();
    }

    @Override
    public void subscribe(Flow.Subscriber subscriber) {

        this.subscribers.add((StringSubscriber) subscriber);
        StringSubscription subscription = new StringSubscription(subscriber);
        this.subscriptions.add(subscription);
        subscriber.onSubscribe(subscription);

    }

    public void publish(String message) {
        for (StringSubscription subscription : this.subscriptions) {
            subscription.request(1);
            subscription.publish(message);
        }
    }
}