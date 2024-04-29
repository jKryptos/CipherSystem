public class Encryption {

    private String plainText;

    final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Encryption(){

    }
    public String encryptText(String plainText, String binaryKey, String[] alphaZero, String[] alphaOne){

        char[] plainTextArray = plainText.toCharArray();
        int zeroCount = 0;
        int oneCount = 0;

        while (binaryKey.length() < plainTextArray.length){
            binaryKey += binaryKey;
        }
        char[] binaryKeyArray = binaryKey.toCharArray();

        for (int i = 0; i < plainTextArray.length; i++) {
            if (plainTextArray[i] != ' ') {
                if (binaryKeyArray[i] == '0') {
                    oneCount = 0;
                    int position = ALPHABET.indexOf(plainTextArray[i]);
                    char encryptChar = getCharFromArray(alphaZero, position, zeroCount);
                    plainTextArray[i] = encryptChar;
                    zeroCount++;
                } else if (binaryKeyArray[i] == '1') {
                    zeroCount = 0;
                    int position = ALPHABET.indexOf(plainTextArray[i]);
                    char encryptChar = getCharFromArray(alphaOne, position, oneCount);
                    plainTextArray[i] = encryptChar;
                    oneCount++;
                }
            }
        }
        return new String(plainTextArray);
    }

    public char getCharFromArray(String[] alphabetArray, int position, int counter){
        char character = ' ';
        character = alphabetArray[counter].charAt(position);

        return character;
    }

    public void setPlainText(String text){
        this.plainText = text.toUpperCase();
    }
    public String getPlainText(){
        return this.plainText;
    }
}
