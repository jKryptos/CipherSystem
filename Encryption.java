public class Encryption {

    private String plainText;

    final String normalAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Encryption(){

    }
    public String encryptText(String plainText, String binaryKey){

        char[] plainTextArray = plainText.toCharArray();

        for(int i = 0; i < plainTextArray.length; i++){
            if (binaryKey.charAt(i) == '0'){
                plainTextArray[i] = 'A';
            }
            if (binaryKey.charAt(i) == '1') {
                plainTextArray[i] = 'X';
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
