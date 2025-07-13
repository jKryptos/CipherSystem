public class Message {

    private String plaintext = "";
    private String ciphertext = "";

    public Message(){

    }

    public void setPlaintext(String plaintext){
        this.plaintext = plaintext.toUpperCase();
    }

    public String getPlaintext(){
        return this.plaintext;
    }

    public void setCiphertext(String ciphertext){
        this.ciphertext = ciphertext.toUpperCase();
    }

    public String getCiphertext(){
        return this.ciphertext;
    }
}
