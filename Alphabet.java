import java.util.Random;

public class Alphabet {

    final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String alphabetZero;
    private String alphabetOne;
    private String[] alphaZeroArray;
    private String[] alphaOneArray;
    Random rand = new Random();

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
        if (alphabetZero == null || alphabetZero.isEmpty()){
            setAlphabetZero("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
        for(int i = 0; i < 26; i++){
            alphabet[i] = (scrambleAlphabet(alphabetZero));
        }
        return alphabet;
    }

    public String[] alphabetOneArraySetup() {
        String[] alphabet = new String[26];
        if(alphabetOne == null || alphabetOne.isEmpty()){
            setAlphabetOne("ZYXWVUTSRQPONMLKJIHGFEDCBA");
        }
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

    public void nullAlphabetArrays(){
        String[] aZero = new String[26];
        String[] aOne = new String[26];
        setAlphaZeroArray(aZero);
        setAlphaOneArray(aOne);
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

    public static String[] arrayRightIndexShift(String[] arrayToShift, int shiftCount){

        int n = arrayToShift.length;
        shiftCount %= n;
        String[] temp = new String[n];

        for(int i = 0; i < n; i++){
            temp[(i + shiftCount) % n] = arrayToShift[i];
        }
        return temp;
    }

    public static String[] arrayLeftIndexShift(String[] arrayToShift, int shiftCount){

        int n = arrayToShift.length;
        shiftCount %= n;
        String[] temp = new String[n];

        for(int i = 0; i < n; i++){
            temp[(i - shiftCount + n )% n] = arrayToShift[i];
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

    public static String[] createTabulaRecta(String alphabet){
        String[] tabulaRecta = new String[alphabet.length()];

        for (int i = 0; i < alphabet.length(); i++){
            i = i % alphabet.length();
            tabulaRecta[i] = alphabet.substring(i) + alphabet.substring(0, i);
        }
        return tabulaRecta;
    }
}

