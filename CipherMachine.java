public class CipherMachine {

    private final Message message;
    private final Alphabet alphabet;
    private final AlphabetService alphabetService;
    private final Key key;

    static final int VALUE_TO_SHIFT_AT = 1; //The number of consecutive keybits, after the first, required for a shift.
    static final int SHIFT_VALUE = 7; //The number of positions the chosen alphabet array will shift

    public CipherMachine(Message message, Key key, Alphabet alphabet, AlphabetService alphabetService){
        this.message = message;
        this.key = key;
        this.alphabet = alphabet;
        this.alphabetService = alphabetService;
    }

    public String encryptText(){
        char[] plainTextArray = message.getPlaintext().toCharArray();
        String[] alphaZero = alphabet.getAlphaZeroArray();
        String[] alphaOne = alphabet.getAlphaOneArray();
        int zeroCount = 0;
        int oneCount = 0;
        int keyCount = 0;

        for (int i = 0; i < plainTextArray.length; i++) {
            if (plainTextArray[i] == ' '){
                continue;
            }
            char keyChar = keyChar(key.getBinaryKey(),keyCount);
            if (keyChar == '0') {
                oneCount = 0;
                int position = Alphabet.ALPHABET.indexOf(plainTextArray[i]);
                plainTextArray[i] = getCharFromArray(alphaZero, position);
                // Shift AFTER a letter has been substituted
                zeroCount++;
                if (zeroCount >= VALUE_TO_SHIFT_AT){
                    alphaZero = alphabetService.arrayLeftIndexShift(alphaZero, SHIFT_VALUE);
                }
            } else if (keyChar == '1') {
                zeroCount = 0;
                int position = Alphabet.ALPHABET.indexOf(plainTextArray[i]);
                plainTextArray[i] = getCharFromArray(alphaOne, position);
                // Shift AFTER a letter has been substituted
                oneCount++;
                if (oneCount >= VALUE_TO_SHIFT_AT){
                    alphaOne = alphabetService.arrayLeftIndexShift(alphaOne, SHIFT_VALUE);
                }
            }
            keyCount++;
        }
        return new String(plainTextArray);
    }

    public String decryptText() {
        char[] cipherTextArray = message.getCiphertext().toCharArray();
        String[] alphaZero = alphabet.getAlphaZeroArray();
        String[] alphaOne = alphabet.getAlphaOneArray();
        int zeroCount = 0;
        int oneCount = 0;
        int keyCount = 0;

        for (int i = 0; i < cipherTextArray.length; i++) {
            if (cipherTextArray[i] == ' '){
                continue;
            }
            char keyChar = keyChar(key.getBinaryKey(),keyCount);
            if (keyChar == '0') {
                oneCount = 0;
                int position = alphaZero[0].indexOf(cipherTextArray[i]); //Always substitutes a letter from the alphabet currently @ index 0 in the array
                cipherTextArray[i] = retrieveDecryptedChar(position);
                // Shift AFTER a letter has been substituted
                zeroCount++;
                if (zeroCount >= VALUE_TO_SHIFT_AT){
                    alphaZero = alphabetService.arrayLeftIndexShift(alphaZero, SHIFT_VALUE);
                }
            } else if (keyChar == '1') {
                zeroCount = 0;
                int position = alphaOne[0].indexOf(cipherTextArray[i]); //Always substitutes a letter from the alphabet currently @ index 0 in the array
                cipherTextArray[i] = retrieveDecryptedChar(position);
                // Shift AFTER a letter has been substituted
                oneCount++;
                if (oneCount >= VALUE_TO_SHIFT_AT){
                    alphaOne = alphabetService.arrayLeftIndexShift(alphaOne, SHIFT_VALUE);
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


