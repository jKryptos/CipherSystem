public class Decryption {

    private String cipherText;
    final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final int VALUE_TO_SHIFT_AT = 2;
    final int SHIFT_VALUE = 7;

    public Decryption(){

    }
    public String decryptText(String cipherText, String binaryKey, String[] alphaZero, String[] alphaOne) {

        char[] cipherTextArray = cipherText.toCharArray();
        int zeroCount = 0;
        int oneCount = 0;

        while (binaryKey.length() < cipherTextArray.length) {
            binaryKey += binaryKey;
        }
        char[] binaryKeyArray = binaryKey.toCharArray();

        for (int i = 0; i < cipherTextArray.length; i++) {
                if (binaryKeyArray[i] == '0' && cipherTextArray[i] != ' ') {
                    oneCount = 0;
                    int position = alphaZero[zeroCount].indexOf(cipherTextArray[i]);
                    char decryptedChar = ALPHABET.charAt(position);
                    cipherTextArray[i] = decryptedChar;
                    zeroCount++;
                        if (zeroCount == VALUE_TO_SHIFT_AT){
                            alphaZero = Alphabet.arrayIndexShift(alphaZero, SHIFT_VALUE);
                        }
                } else if (binaryKeyArray[i] == '1' && cipherTextArray[i] != ' ') {
                    zeroCount = 0;
                    int position = alphaOne[oneCount].indexOf(cipherTextArray[i]);
                    char decryptedChar = ALPHABET.charAt(position);
                    cipherTextArray[i] = decryptedChar;
                    oneCount++;
                        if (oneCount == VALUE_TO_SHIFT_AT){
                            alphaOne = Alphabet.arrayIndexShift(alphaOne, SHIFT_VALUE);
                }
            }
        }
        return new String(cipherTextArray);
    }

        public void setCipherText(String text){
            this.cipherText = text.toUpperCase();
        }
        public String getCipherText () {
            return this.cipherText;
        }
    }