public class Message {

    private String plaintext = "";
    private String ciphertext = "";
    private String decryptedText = "";

    public Message(){

    }

    public void setPlaintext(String plaintext){
        this.plaintext = plaintext.toUpperCase();
    }

    public String getPlaintext(){
        return this.plaintext;
    }

    public void printPlaintextWithNewLines(){

    }

    public void setCiphertext(String ciphertext){
        this.ciphertext = ciphertext.toUpperCase();
    }

    public String getCiphertext(){
        return this.ciphertext;
    }

    public void printCipherTextWithNewLines(){

    }

    public void setDecryptedText(String decryptedText){
        this.decryptedText = decryptedText.toUpperCase();
    }

    public String getDecryptedText(){
        return this.decryptedText;
    }

    public void erasePlaintext(){
        this.plaintext = "";
    }

    public void eraseCipherText(){
        this.ciphertext = "";
    }
}
