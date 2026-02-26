public class CipherMachine {

    static final int VALUE_TO_SHIFT_AT = 1;
    static final int SHIFT_VALUE = 7;

    public String encryptText(String plainText, String binaryKey, String[] alphaZero, String[] alphaOne){
        char[] plainTextArray = plainText.toCharArray();
        int zeroCount = 0;
        int oneCount = 0;
        int keyCount = 0;

        for (int i = 0; i < plainTextArray.length; i++) {
            if (plainTextArray[i] == ' '){
                continue;
            }
            if (keyChar(binaryKey, keyCount) == '0') {
                oneCount = 0;
                int position = Alphabet.ALPHABET.indexOf(plainTextArray[i]);
                plainTextArray[i] = getCharFromArray(alphaZero, position);
                zeroCount++;
                if (zeroCount >= VALUE_TO_SHIFT_AT){
                    alphaZero = Alphabet.arrayLeftIndexShift(alphaZero, SHIFT_VALUE);
                }
            } else if (keyChar(binaryKey, keyCount) == '1') {
                zeroCount = 0;
                int position = Alphabet.ALPHABET.indexOf(plainTextArray[i]);
                plainTextArray[i] = getCharFromArray(alphaOne, position);
                oneCount++;
                if (oneCount >= VALUE_TO_SHIFT_AT){
                    alphaOne = Alphabet.arrayLeftIndexShift(alphaOne, SHIFT_VALUE);
                }
            }
            keyCount++;
        }
        return new String(plainTextArray);
    }

    public String decryptText(String cipherText, String binaryKey, String[] alphaZero, String[] alphaOne) {
        char[] cipherTextArray = cipherText.toCharArray();
        int zeroCount = 0;
        int oneCount = 0;
        int keyCount = 0;

        for (int i = 0; i < cipherTextArray.length; i++) {
            if (cipherTextArray[i] == ' '){
                continue;
            }
            if (keyChar(binaryKey, keyCount) == '0') {
                oneCount = 0;
                int position = alphaZero[0].indexOf(cipherTextArray[i]);
                cipherTextArray[i] = retrieveDecryptedChar(position);
                zeroCount++;
                if (zeroCount >= VALUE_TO_SHIFT_AT){
                    alphaZero = Alphabet.arrayLeftIndexShift(alphaZero, SHIFT_VALUE);
                }
            } else if (keyChar(binaryKey, keyCount) == '1') {
                zeroCount = 0;
                int position = alphaOne[0].indexOf(cipherTextArray[i]);
                cipherTextArray[i] = retrieveDecryptedChar(position);
                oneCount++;
                if (oneCount >= VALUE_TO_SHIFT_AT){
                    alphaOne = Alphabet.arrayLeftIndexShift(alphaOne, SHIFT_VALUE);
                }
            }
            keyCount++;
        }
        return new String(cipherTextArray);
    }

    public char getCharFromArray(String[] alphabetArray, int position){
        char character = ' ';
        character = alphabetArray[0].charAt(position);
        return character;
    }

    public char retrieveDecryptedChar(int position){
        return Alphabet.ALPHABET.charAt(position);
    }

    public char keyChar(String binaryKey, int keyCount){
        return binaryKey.charAt(keyCount % binaryKey.length());
    }
}


