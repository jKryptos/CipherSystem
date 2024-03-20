import java.util.ArrayList;

public class Decryption {

    ArrayList<Character> cipherText = new ArrayList<>();

    public Decryption(){

    }

    public void setCipherText(ArrayList<Character> text){
        this.cipherText = text;
    }

    public ArrayList<Character> getCipherText(){
        return this.cipherText;
    }
}
