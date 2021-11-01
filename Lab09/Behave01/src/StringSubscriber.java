import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow;
import java.util.regex.Pattern;

public abstract class StringSubscriber implements Flow.Subscriber<String> {

    protected StringSubscription subscription;
    protected String fileName = "Behave01/src/Test/";

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = (StringSubscription) subscription;
    }

    @Override
    public void onNext(String item) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(item + "\n");
            fw.close();
            this.onComplete();
        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
            }

    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println(this.getClass().getSimpleName() + " has completed subscribing.");
    }

}