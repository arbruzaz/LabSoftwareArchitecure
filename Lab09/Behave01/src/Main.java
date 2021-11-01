import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringPublisher publisher = new StringPublisher();
        AlphabetSubscriber alphabet = new AlphabetSubscriber("Alphabet.txt");
        NumberSubscriber number = new NumberSubscriber("Number.txt");
        SymbolSubscriber symbol = new SymbolSubscriber("Symbol.txt");

        publisher.subscribe(alphabet);
        publisher.subscribe(number);
        publisher.subscribe(symbol);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name : ");
        String inputText = scanner.nextLine();
        while (!inputText.equals("exit")) {
            publisher.publish(inputText);
            System.out.print("Enter Name : ");
            inputText = scanner.nextLine();
        }
        System.out.println("Exit");
    }
}