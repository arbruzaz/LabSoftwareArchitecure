import java.util.concurrent.Flow;

public class AlphabetSubscriber extends StringSubscriber {
    private boolean check;

    public AlphabetSubscriber(String fileName) {
        super.fileName += fileName;
        this.check = false;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        super.onSubscribe(subscription);
    }

    @Override
    public void onNext(String item) {
        this.check = item.matches(".*[a-zA-Z]+.*");
        if(check){
            super.onNext(item);
        }
    }
}