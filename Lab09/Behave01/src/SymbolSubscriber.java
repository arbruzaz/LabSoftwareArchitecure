import java.util.concurrent.Flow;

public class SymbolSubscriber extends StringSubscriber {
    private boolean check;
    public SymbolSubscriber(String fileName) {
        super.fileName += fileName;
        this.check = false;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        super.onSubscribe(subscription);
    }

    @Override
    public void onNext(String item) {
        this.check = item.matches(".*[\\W]+.*");
        if(check){
            super.onNext(item);
        }
    }
}