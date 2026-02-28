import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Message message = new Message();
        Key key = new Key();
        Alphabet alphabet = new Alphabet();
        Scanner scanner = new Scanner(System.in);
        IOHandler ioHandler = new IOHandler();
        CipherMachine cipherMachine = new CipherMachine(message, key, alphabet);
        UI userInterface = new UI(cipherMachine, message, alphabet, key, scanner, ioHandler);

        userInterface.startUI();
    }
}