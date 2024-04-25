import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

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
        //Set plainText
        encryption.setPlainText(ioHandler.incomingTextFile().toUpperCase());
        System.out.println("This is your message: " + encryption.getPlainText());
        //Ask user for key
        System.out.println("Enter key:");
        key.setKey(scanner.nextLine().toUpperCase());
        scanner.close();
        System.out.println("Your key has been set to: " + key.getKey());
        //Convert key to binaryKey
        key.setBinaryKey(key.stringToBinaryCode(key.getKey()));
        //Set scrambled alphabets
        alphabet.setScrambledAlphabetZero(alphabet.scrambleAlphabet(alphabet.getAlphabetZero()));
        alphabet.setScrambledAlphabetOne(alphabet.scrambleAlphabet(alphabet.getAlphabetOne()));
        System.out.println("Alphebet Zero: " + alphabet.getScrambledAlphabetZero()  + "\n" + "Alphabet One: " + alphabet.getScrambledAlphabetOne());
        //Encryption/Decryption
        String encyrptedString = encryption.encryptText(encryption.getPlainText(), key.getBinaryKey(), alphabet.getScrambledAlphabetZero(), alphabet.getScrambledAlphabetOne());
        System.out.println(encyrptedString);
        System.out.println("Message encrypted.");
        String decryptedString = decryption.decryptText(encyrptedString, key.getBinaryKey(), alphabet.getScrambledAlphabetZero(), alphabet.getScrambledAlphabetOne());
        System.out.println("Decrypting message...");
        System.out.println(decryptedString);
        System.out.println("Message decrypted.");
    }
}