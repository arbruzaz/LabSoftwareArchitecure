import java.util.concurrent.Flow;

public class StringSubscription implements Flow.Subscription {
    private Flow.Subscriber subscriber;
    private boolean addString;
    private boolean completed;

    public StringSubscription(Flow.Subscriber subscriber) {
        this.subscriber = subscriber;
        addString = false;
        completed = false;
    }

    @Override
    public void request(long n) {
        if (n != 0 && !completed) {
            if (n < 0) {
                IllegalArgumentException ex = new IllegalArgumentException();
                subscriber.onError(ex);
            }
            else {
                addString = true;
            }
        }
    }

    @Override
    public void cancel() {
        completed = true;
    }

    public void publish(String message) {
        if (addString) {
            subscriber.onNext(message);
        }
    }

}