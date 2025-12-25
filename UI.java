import java.util.Scanner;

public class UI {

    private final Encryption encryption;
    private final Decryption decryption;
    private final Message message;
    private final Alphabet alphabet;
    private final Key key;
    private final Scanner scanner;
    private final IOHandler ioHandler;


    public UI(Encryption encryption, Decryption decryption, Message message, Alphabet alphabet, Key key, Scanner scanner, IOHandler ioHandler){
        this.encryption = encryption;
        this.decryption = decryption;
        this.message = message;
        this.alphabet = alphabet;
        this.key = key;
        this.scanner = scanner;
        this.ioHandler = ioHandler;
    }

    public void startUI(){
        mainMenu();
    }

    public int userInputInteger(){
        boolean validInput = false;
        int userInput = Constants.DEFAULT_AMOUNT_ZERO;

        do{
            try {
                userInput = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException nfe){
                System.out.println("Invalid input, enter an integer.");
            }
        } while(!validInput);
        return userInput;
    }

    public void mainMenu(){
        while(true){
            Main.generateNewLines(1);
            System.out.println("1. Encrypt Text\n2. Decrypt Text\n3. Key Menu\n4. Alphabet Menu\n5. Message Menu\n0. Quit program");

            int userChoice = userInputInteger();

            switch (userChoice){
                case 1:
                    message.setCiphertext(encryption.encryptText(message.getPlaintext(), key.getBinaryKey(), alphabet.getAlphaZeroArray(), alphabet.getAlphaOneArray()));
                    System.out.println("Message encrypted");
                    break;
                case 2:
                    message.setDecryptedText(decryption.decryptText(message.getCiphertext(), key.getBinaryKey(), alphabet.getAlphaZeroArray(), alphabet.getAlphaOneArray()));
                    System.out.println("Message decrypted");
                    break;
                case 3:
                    keyMenu();
                    break;
                case 4:
                    alphabetMenu();
                    break;
                case 5:
                    messageMenu();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void keyMenu(){
        while(true){
            Main.generateNewLines(1);
            System.out.println("1. Set key\n2. Erase key\n3. View key\n0. Main menu");

            int userChoice = userInputInteger();

            switch(userChoice){
                case 1:
                    System.out.println("Enter keyword: ");
                    String keyword = scanner.nextLine();
                    key.setKey(keyword);
                    key.setBinaryKey(key.stringToBinaryCode(key.getKey()));
                    break;
                case 2:
                    key.eraseKey();
                    System.out.println("Key has been erased.");
                    break;
                case 3:
                    System.out.println("The current key is: " + key.getKey());
                    System.out.println("The binary key is: " + key.getBinaryKey());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void alphabetMenu(){
        while(true){
            Main.generateNewLines(1);
            System.out.println("1. View alphabet\n2. Set array alphabets \n3. View array alphabets\n4. Generate alphabet arrays \n5. View alphabet arrays\n" +
                    "6. Reset alphabet arrays to default positions\n7. Erase array alphabets\n8. Erase alphabet arrays\n0. Return to main menu");

            int userChoice = userInputInteger();

            switch(userChoice){
                case 1:
                    System.out.println(Alphabet.ALPHABET);
                    break;
                case 2:
                    alphabetArrayMenu();
                    break;
                case 3:
                    System.out.println("AlphabetZERO: " + alphabet.getAlphabetZero() + "\nAlphabetONE: " + alphabet.getAlphabetOne());
                    break;
                case 4:
                    alphabet.setAlphaZeroArray(alphabet.alphabetZeroArraySetup());
                    alphabet.setAlphaOneArray(alphabet.alphabetOneArraySetup());
                    break;
                case 5:
                    alphabet.printAlphabetArrays();
                    break;
                case 6:
                    System.out.println("Currently not implemented");
                    break;
                case 7:
                    alphabet.setAlphabetZero("");
                    alphabet.setAlphabetOne("");
                    break;
                case 8:
                    alphabet.resetAlphabetArrays();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }    
    }

    public void alphabetArrayMenu(){
        while(true){
            Main.generateNewLines(1);
            System.out.println("1. Enter array alphabet Zero\n2. Enter array alphabet One\n0. Return to previous menu");

            int userChoice = userInputInteger();

            switch(userChoice){
                case 1:
                        System.out.println("Enter alphabet: ");
                        String alphabetZero = scanner.nextLine();
                        if (alphabetZero.length() != 26){
                            System.out.println("Not long enough");
                        } else {
                            alphabet.setAlphabetZero(alphabetZero);
                            break;
                        }
                        break;
                case 2:
                        System.out.println("Enter alphabet: ");
                        String alphabetOne = scanner.nextLine();
                        if (alphabetOne.length() != 26){
                            System.out.println("Not long enough");
                        } else {
                            alphabet.setAlphabetOne(alphabetOne);
                            break;
                        }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void messageMenu(){
        while(true){
            Main.generateNewLines(1);
            System.out.println("1. Load message from file\n2. View plaintext\n3. View ciphertext\n4. View decrypted text\n5. Erase Plaintext\n6. Erase Ciphertext\n0. Return to main menu");

            int userChoice = userInputInteger();

            switch(userChoice){
                case 1:
                    String incomingFile = ioHandler.incomingTextFile("plaintext2.txt");
                    if (incomingFile == null){
                        System.out.println("File not found, plaintext is empty.");
                    } else {
                        message.setPlaintext(ioHandler.incomingTextFile("plaintext2.txt"));
                    }
                    break;
                case 2:
                    System.out.println(message.printTextWithNewLines(message.getPlaintext()));
                    break;
                case 3:
                    System.out.println(message.printTextWithNewLines(message.getCiphertext()));
                    break;
                case 4:
                    System.out.println(message.printTextWithNewLines(message.getDecryptedText()));
                    break;
                case 5:
                    message.erasePlaintext();
                    break;
                case 6:
                    message.eraseCipherText();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
