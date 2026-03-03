import java.util.Random;

public class Alphabet {

    final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final static String REVERSE_ALPHABET = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
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

