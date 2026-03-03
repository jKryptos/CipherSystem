import java.util.Scanner;

public class UI {

    private final CipherMachine cipherMachine;
    private final UserContext userContext;
    private final Scanner scanner;
    private final IOHandler ioHandler;

    public UI(CipherMachine cipherMachine, UserContext userContext, Scanner scanner, IOHandler ioHandler){
        this.cipherMachine = cipherMachine;
        this.userContext = userContext;
        this.scanner = scanner;
        this.ioHandler = ioHandler;
    }

    public void startUI(){
        mainMenu();
    }

    public int userInputInteger(){
        boolean validInput = false;
        int userInput = 0;

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
            generateNewLines(1);
            System.out.println("1. Encrypt Text\n2. Decrypt Text\n3. Key Menu\n4. Alphabet Menu\n5. Message Menu\n0. Quit program");

            int userChoice = userInputInteger();

            switch (userChoice){
                case 1:
                    userContext.message.setCiphertext(cipherMachine.encryptText());
                    System.out.println("Message encrypted");
                    break;
                case 2:
                    userContext.message.setDecryptedText(cipherMachine.decryptText());
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
            generateNewLines(1);
            System.out.println("1. Set key\n2. Erase key\n3. View key\n0. Main menu");

            int userChoice = userInputInteger();

            switch(userChoice){
                case 1:
                    System.out.println("Enter keyword: ");
                    String keyword = scanner.nextLine();
                    userContext.key.setKey(keyword);
                    break;
                case 2:
                    userContext.key.eraseKey();
                    System.out.println("Key has been erased.");
                    break;
                case 3:
                    System.out.println("The current key is: " + userContext.key.getKey());
                    System.out.println("The binary key is: " + userContext.key.getBinaryKey());
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
            generateNewLines(1);
            System.out.println("1. View alphabet\n2. Set array alphabets \n3. View array alphabets\n4. Generate alphabet arrays \n5. View alphabet arrays\n" +
                    "6. Generate Tabula Recta and Reverse Tabula Recta\n7. Erase array alphabets\n8. Erase alphabet arrays\n0. Return to main menu");

            int userChoice = userInputInteger();

            switch(userChoice){
                case 1:
                    System.out.println(Alphabet.ALPHABET);
                    break;
                case 2:
                    alphabetArrayMenu();
                    break;
                case 3:
                    System.out.println("AlphabetZERO: " + userContext.alphabet.getAlphabetZero() + "\nAlphabetONE: " + userContext.alphabet.getAlphabetOne());
                    break;
                case 4:
                    userContext.alphabetService.alphabetZeroArraySetup();
                    userContext.alphabetService.alphabetOneArraySetup();
                    break;
                case 5:
                    userContext.alphabet.printAlphabetArrays();
                    break;
                case 6:
                    userContext.alphabet.setAlphaZeroArray(userContext.alphabetService.createTabulaRecta(Alphabet.REVERSE_ALPHABET));
                    userContext.alphabet.setAlphaOneArray(userContext.alphabetService.createTabulaRecta(Alphabet.ALPHABET));
                    break;
                case 7:
                    userContext.alphabet.setAlphabetZero("");
                    userContext.alphabet.setAlphabetOne("");
                    break;
                case 8:
                    userContext.alphabetService.clearAlphabetArrays();
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
            generateNewLines(1);
            System.out.println("1. Enter array alphabet Zero\n2. Enter array alphabet One\n0. Return to previous menu");

            int userChoice = userInputInteger();

            switch(userChoice){
                case 1:
                        System.out.println("Enter alphabet: ");
                        String alphabetZero = scanner.nextLine();
                        if (alphabetZero.length() != 26){
                            System.out.println("Not long enough");
                        } else {
                            userContext.alphabet.setAlphabetZero(alphabetZero);
                            break;
                        }
                        break;
                case 2:
                        System.out.println("Enter alphabet: ");
                        String alphabetOne = scanner.nextLine();
                        if (alphabetOne.length() != 26){
                            System.out.println("Not long enough");
                        } else {
                            userContext.alphabet.setAlphabetOne(alphabetOne);
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
            generateNewLines(1);
            System.out.println("1. Load message from file\n2. View plaintext\n3. View ciphertext\n4. View decrypted text\n5. Erase Plaintext\n6. Erase Ciphertext\n0. Return to main menu");

            int userChoice = userInputInteger();

            switch(userChoice){
                case 1:
                    System.out.println("Enter file name");
                    String userInput = scanner.nextLine();
                    String incomingFile = ioHandler.incomingTextFile(userInput);
                    if (incomingFile == null){
                        System.out.println("File not found, plaintext is empty.");
                    } else {
                        userContext.message.setPlaintext(ioHandler.incomingTextFile(userInput));
                    }
                    break;
                case 2:
                    System.out.println(userContext.message.formatText(userContext.message.getPlaintext()));
                    break;
                case 3:
                    System.out.println(userContext.message.formatText(userContext.message.getCiphertext()));
                    break;
                case 4:
                    System.out.println(userContext.message.formatText(userContext.message.getDecryptedText()));
                    break;
                case 5:
                    userContext.message.erasePlainText();
                    break;
                case 6:
                    userContext.message.eraseCipherText();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void generateNewLines(int amountOfNewLines){
        for(int i = 0; i < amountOfNewLines; i++){
            System.out.println();
        }
    }
}
