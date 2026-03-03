import java.util.Scanner;

public class ApplicationFactory {

    public UI createUI(){

        Message message = new Message();
        Key key = new Key();
        Alphabet alphabet = new Alphabet();
        Scanner scanner = new Scanner(System.in);
        IOHandler ioHandler = new IOHandler();
        AlphabetService alphabetService = new AlphabetService(alphabet);
        UserContext userContext = new UserContext(key, message, alphabet, alphabetService);
        CipherMachine cipherMachine = new CipherMachine(userContext);

        return new UI(cipherMachine, userContext, scanner, ioHandler);
    }
}
