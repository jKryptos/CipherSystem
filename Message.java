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
            if (wordCount == 15) {
                newParagraph.append(System.lineSeparator());
                wordCount = 0;
            }
        }
        return newParagraph;
    }

    public void erasePlaintext(){
        this.plaintext = "";
    }

    public void eraseCipherText(){
        this.ciphertext = "";
    }
}
