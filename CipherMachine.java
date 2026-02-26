public class CipherMachine {

    static final int VALUE_TO_SHIFT_AT = 2;
    static final int SHIFT_VALUE = 7;

    public String encryptText(String plainText, String binaryKey, String[] alphaZero, String[] alphaOne){
        char[] plainTextArray = plainText.toCharArray();
        int zeroCount = 0;
        int oneCount = 0;
        int keyCounter = 0;

        for (int i = 0; i < plainTextArray.length; i++) {

            if (plainTextArray[i] == ' '){
                continue;
            }
            char keyChar = binaryKey.charAt(keyCounter % binaryKey.length());

            if (keyChar == '0') {
                oneCount = 0;
                int position = Alphabet.ALPHABET.indexOf(plainTextArray[i]);
                char encryptChar = getCharFromArray(alphaZero, position);
                plainTextArray[i] = encryptChar;
                zeroCount++;
                if (zeroCount >= VALUE_TO_SHIFT_AT){
                    alphaZero = Alphabet.arrayLeftIndexShift(alphaZero, SHIFT_VALUE);
                }
            } else if (keyChar == '1') {
                zeroCount = 0;
                int position = Alphabet.ALPHABET.indexOf(plainTextArray[i]);
                char encryptChar = getCharFromArray(alphaOne, position);
                plainTextArray[i] = encryptChar;
                oneCount++;
                if (oneCount >= VALUE_TO_SHIFT_AT){
                    alphaOne = Alphabet.arrayLeftIndexShift(alphaOne, SHIFT_VALUE);
                }
            }
            keyCounter++;
        }
        return new String(plainTextArray);
    }

    public char getCharFromArray(String[] alphabetArray, int position){
        char character = ' ';
        character = alphabetArray[0].charAt(position);
        return character;
    }

    public String decryptText(String cipherText, String binaryKey, String[] alphaZero, String[] alphaOne) {
        char[] cipherTextArray = cipherText.toCharArray();
        int zeroCount = 0;
        int oneCount = 0;
        int keyCounter = 0;

        for (int i = 0; i < cipherTextArray.length; i++) {
            if (cipherTextArray[i] == ' '){
                continue;
            }
            char keyChar = binaryKey.charAt(keyCounter % binaryKey.length());

            if (keyChar == '0') {
                oneCount = 0;
                int position = alphaZero[0].indexOf(cipherTextArray[i]);
                char decryptedChar = Alphabet.ALPHABET.charAt(position);
                cipherTextArray[i] = decryptedChar;
                zeroCount++;
                if (zeroCount >= VALUE_TO_SHIFT_AT){
                    alphaZero = Alphabet.arrayLeftIndexShift(alphaZero, SHIFT_VALUE);
                }
            } else if (keyChar == '1') {
                zeroCount = 0;
                int position = alphaOne[0].indexOf(cipherTextArray[i]);
                char decryptedChar = Alphabet.ALPHABET.charAt(position);
                cipherTextArray[i] = decryptedChar;
                oneCount++;
                if (oneCount >= VALUE_TO_SHIFT_AT){
                    alphaOne = Alphabet.arrayLeftIndexShift(alphaOne, SHIFT_VALUE);
                }
            }
            keyCounter++;
        }
        return new String(cipherTextArray);
    }
}


