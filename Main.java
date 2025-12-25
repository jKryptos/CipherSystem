import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Encryption encryption = new Encryption();
        Decryption decryption = new Decryption();
        Message message = new Message();
        Key key = new Key();
        Alphabet alphabet = new Alphabet();
        Scanner scanner = new Scanner(System.in);
        IOHandler ioHandler = new IOHandler();
        UI userInterface = new UI(encryption, decryption, message, alphabet, key, scanner, ioHandler);

        userInterface.startUI();
    }

    public static void generateNewLines(int amountOfNewLines){
        for(int i = 0; i < amountOfNewLines; i++){
            System.out.println();
        }
    }
}