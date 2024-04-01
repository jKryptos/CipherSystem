import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Initialize all objects
        IOHandler ioHandler = new IOHandler();
        Key key = new Key();
        Alphabet alphabet = new Alphabet();
        Encryption encryption = new Encryption();
        Decryption decryption = new Decryption();
        Scanner scanner = new Scanner(System.in);

        //Set default alphabets
        alphabet.setAlphabetZero("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        alphabet.setAlphabetOne("ZYXWVUTSRQPONMLKJIHGFEDCBA");

        //Ask user for key
        System.out.println("Enter key:");
        key.setKey(scanner.nextLine().toUpperCase());
        scanner.close();
        System.out.println("Your key has been set to: " + key.getKey());
        //Convert key to binaryKey
        key.setBinaryKey(key.stringToBinaryCodeReturn(key.getKey()));
        //Set scrambled alphabets
        alphabet.setScrambledAlphabetZero(alphabet.scrambleAlphabet(alphabet.getAlphabetZero()));
        alphabet.setScrambledAlphabetOne(alphabet.scrambleAlphabet(alphabet.getAlphabetOne()));

        //Println for testing
        System.out.println("Alphabet ZERO: " + alphabet.getScrambledAlphabetZero());
        System.out.println("Alphabet ONE: " + alphabet.getScrambledAlphabetOne());
        System.out.println("binaryKey: " + key.getBinaryKey());
    }
}