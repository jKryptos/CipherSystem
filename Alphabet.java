import java.util.Random;

public class Alphabet {

    private String alphabetZero;
    private String alphabetOne;
    private String scrambledAlphabetZero;
    private String scrambledAlphabetOne;

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
