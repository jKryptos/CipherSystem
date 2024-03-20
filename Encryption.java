import java.util.ArrayList;

public class Encryption {

    ArrayList<Character> plainText = new ArrayList<>();

    public Encryption(){

    }

    public void setPlainText(ArrayList<Character> text){
        this.plainText = text;
    }

    public ArrayList<Character> getPlainText(){
        return this.plainText;
    }
}
