import java.util.Random;

public class Alphabet {

    private String alphabetZero;
    private String alphabetOne;

    public Alphabet(){

    }
    public void setAlphabetZero(String alphabetZero) {
        this.alphabetZero = alphabetZero;
    }
    public void setAlphabetOne(String alphabetOne) {
        this.alphabetOne = alphabetOne;
    }
    public String getAlphabetZero(){
        return this.alphabetZero;
    }
    public String getAlphabetOne(){
        return this.alphabetOne;
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
