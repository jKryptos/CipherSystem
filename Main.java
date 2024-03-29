import java.util.Scanner;

public class Main {

    public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {

        IOHandler ioHandler = new IOHandler();
        Key key = new Key();
        Encryption encryption = new Encryption();
        Decryption decryption = new Decryption();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter key:");
        key.setKey(scanner.nextLine().toUpperCase());
        scanner.close();
        System.out.println("Your key has been set to: " + key.getKey() + "\nConverted to binary is: " + key.stringToBinaryCodeReturn(key.getKey()));
    }
}