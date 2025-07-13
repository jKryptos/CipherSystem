import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        //Initialize all objects
        IOHandler ioHandler = new IOHandler();
        Message message = new Message();
        Key key = new Key();
        Alphabet alphabet = new Alphabet();
        Encryption encryption = new Encryption();
        Decryption decryption = new Decryption();
        Scanner scanner = new Scanner(System.in);

        //Set default alphabets
        alphabet.setAlphabetZero("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        alphabet.setAlphabetOne("ZYXWVUTSRQPONMLKJIHGFEDCBA");
        //Set plainText
        //encryption.setPlainText("Bilbo Baggins celebrates his birthday and leaves the Ring to Frodo his heir Gandalf a wizard suspects it is a Ring of Power seventeen years later he confirms it was lost by the Dark Lord Sauron and counsels Frodo to take it away from the Shire Gandalf leaves promising to return but fails to do so Frodo sets out on foot with his cousin Pippin Took and gardener Sam Gamgee They are pursued by Black Riders but meet some Elves whose singing to Elbereth wards off the Riders The Hobbits take an evasive shortcut to Bucklebury Ferry where they meet their friend Merry Brandybuck Merry and Pippin reveal they know about the Ring and insist on joining Frodo on his journey They try to shake off the Black Riders by cutting through the Old Forest Merry and Pippin are trapped by the malign Old Man Willow but are rescued by Tom Bombadil Leaving Toms house they are caught by a barrowwight Frodo awakening from the barrowwights spell calls Tom Bombadil who frees them and gives them ancient swords from the wights hoard The Hobbits reach the village of Bree where they meet Strider a Ranger The innkeeper gives Frodo an old letter from Gandalf which identifies Strider as a friend Knowing the Black Riders will attempt to seize the Ring Strider guides the group toward the Elvish sanctuary of Rivendell At Weathertop they are attacked by five Black Riders Their leader wounds Frodo with a cursed blade Strider fights them off and treats Frodo with the herb athelas They are joined by the Elf Glorfindel who rides with Frodo now deathly ill towards Rivendell The Black Riders pursue Frodo into the Ford of Bruinen where they are swept away by flood waters summoned by Elrond");
        message.setPlaintext(ioHandler.incomingTextFile().toUpperCase());
        System.out.println("This is your message: \n" + message.getPlaintext());
        //Ask user for key
        System.out.println("Enter key:");
        key.setKey(scanner.nextLine().toUpperCase());
        scanner.close();
        System.out.println("Your key has been set to: " + key.getKey());
        //Convert key to binaryKey
        key.setBinaryKey(key.stringToBinaryCode(key.getKey()));
        System.out.println("Binary representation of key: " + key.getBinaryKey());
        //Set scrambled alphabetArrays
        alphabet.setAlphaZeroArray(alphabet.alphabetZeroArraySetup());
        alphabet.setAlphaOneArray(alphabet.alphabetOneArraySetup());
        //Encryption/Decryption
        message.setCiphertext(encryption.encryptText(message.getPlaintext(), key.getBinaryKey(), alphabet.getAlphaZeroArray(), alphabet.getAlphaOneArray()));
        System.out.println(message.getCiphertext());
        System.out.println("Message encrypted.\n");
        String decryptedString = decryption.decryptText(message.getCiphertext(), key.getBinaryKey(), alphabet.getAlphaZeroArray(), alphabet.getAlphaOneArray());
        System.out.println("Decrypting message...");
        System.out.println(decryptedString);
        System.out.println("Message decrypted.\n");
        System.out.println("Alphabet arrays used: ");
        alphabet.printAlphabetArrays();
    }
}