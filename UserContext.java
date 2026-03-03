public class UserContext {

    public final Key key;
    public final Message message;
    public final Alphabet alphabet;
    public final AlphabetService alphabetService;

    public UserContext(Key key, Message message, Alphabet alphabet, AlphabetService alphabetService){
        this.key = key;
        this.message = message;
        this.alphabet = alphabet;
        this.alphabetService = alphabetService;
    }
}
