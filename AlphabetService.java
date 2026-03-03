import java.util.Random;

public class AlphabetService {

    private final Alphabet alphabet;
    Random rand = new Random();

    public AlphabetService(Alphabet alphabet){
        this.alphabet = alphabet;
    }

    public void alphabetZeroArraySetup() {
        String[] alphabetArray = new String[26];
        if (alphabet.getAlphabetZero() == null || alphabet.getAlphabetZero().isEmpty()){
            alphabet.setAlphabetZero("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
        for(int i = 0; i < 26; i++){
            alphabetArray[i] = (scrambleAlphabet(alphabet.getAlphabetZero()));
        }
        alphabet.setAlphaZeroArray(alphabetArray);
    }

    public void alphabetOneArraySetup() {
        String[] alphabetArray = new String[26];
        if(alphabet.getAlphabetOne() == null || alphabet.getAlphabetOne().isEmpty()){
            alphabet.setAlphabetOne("ZYXWVUTSRQPONMLKJIHGFEDCBA");
        }
        for(int i = 0; i < 26; i++){
            alphabetArray[i] = (scrambleAlphabet(alphabet.getAlphabetOne()));
        }
        alphabet.setAlphaOneArray(alphabetArray);
    }

    public String[] createTabulaRecta(String alphabet){
        String[] tabulaRecta = new String[alphabet.length()];

        for (int i = 0; i < alphabet.length(); i++){
            i = i % alphabet.length();
            tabulaRecta[i] = alphabet.substring(i) + alphabet.substring(0, i);
        }
        return tabulaRecta;
    }

    public String[] arrayLeftIndexShift(String[] arrayToShift, int shiftCount){

        int n = arrayToShift.length;
        shiftCount %= n;
        String[] temp = new String[n];

        for(int i = 0; i < n; i++){
            temp[(i - shiftCount + n )% n] = arrayToShift[i];
        }
        return temp;
    }

    public String[] arrayRightIndexShift(String[] arrayToShift, int shiftCount){

        int n = arrayToShift.length;
        shiftCount %= n;
        String[] temp = new String[n];

        for(int i = 0; i < n; i++){
            temp[(i + shiftCount) % n] = arrayToShift[i];
        }
        return temp;
    }

    public String scrambleAlphabet(String targetAlphabet){

        char[] alphabet = targetAlphabet.toCharArray();

        for(int i = alphabet.length - 1; i > 0; i--){

            int j = rand.nextInt(i + 1);

            char temp = alphabet[i];
            alphabet[i] = alphabet[j];
            alphabet[j] = temp;
        }
        return new String(alphabet);
    }

    public void clearAlphabetArrays(){
        String[] aZero = new String[26];
        String[] aOne = new String[26];
        alphabet.setAlphaZeroArray(aZero);
        alphabet.setAlphaOneArray(aOne);
    }


}
