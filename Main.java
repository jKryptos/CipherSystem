import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        IOHandler ioHandler = new IOHandler();
        Key key = new Key();
        Alphabet alphabet = new Alphabet();
        Encryption encryption = new Encryption();
        Decryption decryption = new Decryption();
        Scanner scanner = new Scanner(System.in);

        alphabet.setAlphabetZero("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        alphabet.setAlphabetOne("ZYXWVUTSRQPONMLKJIHGFEDCBA");

        System.out.println("Enter key:");
        key.setKey(scanner.nextLine().toUpperCase());
        scanner.close();
        System.out.println("Your key has been set to: " + key.getKey() + "\nConverted to binary is: " + key.stringToBinaryCodeReturn(key.getKey()));

        String alphabetZero = alphabet.getAlphabetZero();
        String alphabetOne = alphabet.getAlphabetOne();

        for(int i = 0;i < 5;i++){
            System.out.println(alphabet.scrambleAlphabet(alphabetZero));
            System.out.println(alphabet.scrambleAlphabet(alphabetOne));
            System.out.println(" ");
        }
    }
}