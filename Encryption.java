public class Encryption {

    private String plainText;
    final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final int VALUE_TO_SHIFT_AT = 2;
    final int SHIFT_VALUE = 7;

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
                if (binaryKeyArray[i] == '0' && plainTextArray[i] != ' ') {
                    oneCount = 0;
                    int position = ALPHABET.indexOf(plainTextArray[i]);
                    char encryptChar = getCharFromArray(alphaZero, position, zeroCount);
                    plainTextArray[i] = encryptChar;
                    zeroCount++;
                        if (zeroCount == VALUE_TO_SHIFT_AT){
                            alphaZero = Alphabet.arrayIndexShift(alphaZero, SHIFT_VALUE);
                        }
                } else if (binaryKeyArray[i] == '1' && plainTextArray[i] != ' ') {
                    zeroCount = 0;
                    int position = ALPHABET.indexOf(plainTextArray[i]);
                    char encryptChar = getCharFromArray(alphaOne, position, oneCount);
                    plainTextArray[i] = encryptChar;
                    oneCount++;
                        if (oneCount == VALUE_TO_SHIFT_AT){
                            alphaOne = Alphabet.arrayIndexShift(alphaOne, SHIFT_VALUE);
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
