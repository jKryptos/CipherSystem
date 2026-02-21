public class CipherMachine {

    static final int VALUE_TO_SHIFT_AT = 2;
    static final int SHIFT_VALUE = 7;

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
                int position = Alphabet.ALPHABET.indexOf(plainTextArray[i]);
                char encryptChar = getCharFromArray(alphaZero, position, zeroCount);
                plainTextArray[i] = encryptChar;
                zeroCount++;
                if (zeroCount >= VALUE_TO_SHIFT_AT){
                    alphaZero = Alphabet.arrayIndexShift(alphaZero, SHIFT_VALUE);
                }
            } else if (binaryKeyArray[i] == '1' && plainTextArray[i] != ' ') {
                zeroCount = 0;
                int position = Alphabet.ALPHABET.indexOf(plainTextArray[i]);
                char encryptChar = getCharFromArray(alphaOne, position, oneCount);
                plainTextArray[i] = encryptChar;
                oneCount++;
                if (oneCount >= VALUE_TO_SHIFT_AT){
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
                char decryptedChar = Alphabet.ALPHABET.charAt(position);
                cipherTextArray[i] = decryptedChar;
                zeroCount++;
                if (zeroCount >= VALUE_TO_SHIFT_AT){
                    alphaZero = Alphabet.arrayIndexShift(alphaZero, SHIFT_VALUE);
                }
            } else if (binaryKeyArray[i] == '1' && cipherTextArray[i] != ' ') {
                zeroCount = 0;
                int position = alphaOne[oneCount].indexOf(cipherTextArray[i]);
                char decryptedChar = Alphabet.ALPHABET.charAt(position);
                cipherTextArray[i] = decryptedChar;
                oneCount++;
                if (oneCount >= VALUE_TO_SHIFT_AT){
                    alphaOne = Alphabet.arrayIndexShift(alphaOne, SHIFT_VALUE);
                }
            }
        }
        return new String(cipherTextArray);
    }
}


