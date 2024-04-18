public class Encryption {

    private String plainText;

    final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Encryption(){

    }
    public String encryptText(String plainText, String binaryKey, String alphaZero, String alphaOne){

        char[] plainTextArray = plainText.toCharArray();

        while (binaryKey.length() < plainTextArray.length){
            binaryKey += binaryKey;
        }
        char[] binaryKeyArray = binaryKey.toCharArray();

        for(int i = 0; i < plainTextArray.length; i++){
            if (binaryKeyArray[i] == '0'){
                int position = ALPHABET.indexOf(plainTextArray[i]);
                char encryptChar = alphaZero.charAt(position);
                plainTextArray[i] = encryptChar;
            }
            else if (binaryKeyArray[i] == '1') {
                int position = ALPHABET.indexOf(plainTextArray[i]);
                char encryptChar = alphaOne.charAt(position);
                plainTextArray[i] = encryptChar;
            }
        }
        return new String(plainTextArray);
    }

    public void setPlainText(String text){
        this.plainText = text.toUpperCase();
    }
    public String getPlainText(){
        return this.plainText;
    }
}
