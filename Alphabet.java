import java.util.Random;

public class Alphabet {

    final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String alphabetZero;
    private String alphabetOne;
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

    public static String[] arrayIndexShift(String[] arrayToShift, int shiftCount) {

        String[] temp = new String[26];

        for (int j = 0; j < shiftCount; j++) {
            String tempString = arrayToShift[0];

            for (int i = 0; i < arrayToShift.length; i++) {
                temp[i] = arrayToShift[(i + 1) % 26];
            }
            temp[25] = tempString;
        }
        return temp;
    }

    public void printAlphabetArrays() {
        String[] zero = getAlphaZeroArray();
        String[] one = getAlphaOneArray();

        System.out.println("Zero Array: ");
        for (int i = 0; i < zero.length;i++){
            if(i <= 9){
                System.out.println(i + "  " + zero[i]);
            } else {
                System.out.println(i + " " + zero[i]);
            }
        }
        System.out.println(" ");
        System.out.println("One Array: ");
        for(int i = 0; i < one.length;i++){
            if(i <= 9){
                System.out.println(i + "  " + one[i]);
            } else {
                System.out.println(i + " " + one[i]);
            }
        }
    }
}

