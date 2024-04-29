import java.util.Random;

public class Alphabet {

    private String alphabetZero;
    private String alphabetOne;
    private String scrambledAlphabetZero;
    private String scrambledAlphabetOne;
    private String[] alphaZeroArray;
    private String[] alphaOneArray;

    public Alphabet(){

    }
    public void setAlphabetZero(String alphabetZero) {
        this.alphabetZero = alphabetZero;
    }
    public String getAlphabetZero(){
        return this.alphabetZero;
    }

    public void setAlphabetOne(String alphabetOne) {
        this.alphabetOne = alphabetOne;
    }
    public String getAlphabetOne(){
        return this.alphabetOne;
    }

    public void setScrambledAlphabetZero(String alphabetZero){
        this.scrambledAlphabetZero = alphabetZero;
    }
    public String getScrambledAlphabetZero(){
        return this.scrambledAlphabetZero;
    }

    public void setScrambledAlphabetOne(String alphabetOne){
        this.scrambledAlphabetOne = alphabetOne;
    }
    public String getScrambledAlphabetOne(){
        return this.scrambledAlphabetOne;
    }

    public String[] alphabetZeroArraySetup() {
        String[] alphabet = new String[26];

        for(int i = 0; i < 26; i++){
            alphabet[i] = (scrambleAlphabet(alphabetZero));
        }
        return alphabet;
    }

    public String[] alphabetOneArraySetup() {
        String[] alphabet = new String[26];

        for(int i = 0; i < 26; i++){
            alphabet[i] = (scrambleAlphabet(alphabetOne));
        }
        return alphabet;
    }

    public void setAlphaZeroArray(String[] alphabetArray){
        this.alphaZeroArray = alphabetArray;
    }
    public String[] getAlphaZeroArray(){
        return this.alphaZeroArray;
    }

    public void setAlphaOneArray(String[] alphabetArray){
        this.alphaOneArray = alphabetArray;
    }
    public String[] getAlphaOneArray(){
        return this.alphaOneArray;
    }

    public String scrambleAlphabet(String targetAlphabet){

        Random rand = new Random();
        char[] alphabet = targetAlphabet.toCharArray();

        for(int i = 0; i < alphabet.length; i++){
            int j = rand.nextInt(alphabet.length);

            char temp = alphabet[i];
            alphabet[i] = alphabet[j];
            alphabet[j] = temp;
        }
        return new String(alphabet);
    }
}

