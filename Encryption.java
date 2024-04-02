public class Encryption {

    private String plainText;

    final String normalAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Encryption(){

    }
    //Need to implement a way to compare normal alphabet to random alphabets, currently broken because I'm comparing a 26 char alphabet to a longer plaintext
    public String encryptText(String plainText, String binaryKey, String alphaZero, String alphaOne){

        char[] plainTextArray = plainText.toCharArray();
        char[] alphaZeroArray = alphaZero.toCharArray();
        char[] alphaOneArray = alphaOne.toCharArray();

        while (binaryKey.length() < plainTextArray.length){
            binaryKey += binaryKey;
        }
        char[] binaryKeyArray = binaryKey.toCharArray();

        for(int i = 0; i < plainTextArray.length; i++){
            if (binaryKeyArray[i] == '0'){
                plainTextArray[i] = alphaZeroArray[i];
            }
            if (binaryKeyArray[i] == '1') {
                plainTextArray[i] = alphaOneArray[i];
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
