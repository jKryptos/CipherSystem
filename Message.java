public class Message {

    private String plaintext = "";
    private String ciphertext = "";
    private String decryptedText = "";

    static final int WHEN_TO_MAKE_NEW_LINE = 20;

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


    public void setDecryptedText(String decryptedText){
        this.decryptedText = decryptedText.toUpperCase();
    }

    public String getDecryptedText(){
        return this.decryptedText;
    }

    public StringBuilder printTextWithNewLines(String textToFormat){
        String[] wordsInText = textToFormat.trim().split("\\s+");
        StringBuilder newParagraph = new StringBuilder();
        int wordCount = 0;
        for (String s : wordsInText) {
            if(wordCount > 0){
                newParagraph.append(" ");
            }
            newParagraph.append(s);
            wordCount++;
            if (wordCount == WHEN_TO_MAKE_NEW_LINE) {
                newParagraph.append(System.lineSeparator());
                wordCount = 0;
            }
        }
        return newParagraph;
    }

    public void erasePlainText(){
        this.plaintext = "";
    }

    public void eraseCipherText(){
        this.ciphertext = "";
    }
}
