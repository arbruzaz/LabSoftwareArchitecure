import java.util.concurrent.Flow;

public class NumberSubscriber extends StringSubscriber {
    private boolean check;
    public NumberSubscriber(String fileName) {
        super.fileName += fileName;
        this.check = false;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        super.onSubscribe(subscription);
    }

    @Override
    public void onNext(String item) {
        this.check = item.matches("[0-9]+");
        if(check){
            super.onNext(item);
        }
    }
}