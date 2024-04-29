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
            if (cipherTextArray[i] != ' ') {
                if (binaryKeyArray[i] == '0') {
                    oneCount = 0;
                    int position = alphaZero[zeroCount].indexOf(cipherTextArray[i]);
                    char decryptedChar = ALPHABET.charAt(position);
                    cipherTextArray[i] = decryptedChar;
                    zeroCount++;
                        if (zeroCount == VALUE_TO_SHIFT_AT){
                            alphaZero = arrayIndexShift(alphaZero, SHIFT_VALUE);
                    }
                } else if (binaryKeyArray[i] == '1') {
                    zeroCount = 0;
                    int position = alphaOne[oneCount].indexOf(cipherTextArray[i]);
                    char decryptedChar = ALPHABET.charAt(position);
                    cipherTextArray[i] = decryptedChar;
                    oneCount++;
                        if (oneCount == VALUE_TO_SHIFT_AT){
                            alphaOne = arrayIndexShift(alphaOne, SHIFT_VALUE);
                    }
                }
            }
        }
        return new String(cipherTextArray);
    }

    public String[] arrayIndexShift(String[] arrayToShift, int shiftCount) {

        String[] temp = new String[26];

        for (int j = 0; j < shiftCount; j++) {
            String tempString = arrayToShift[0];

            for (int i = 0; i < arrayToShift.length; i++) {
                temp[i] = arrayToShift[(i + 1) % 26];
            }
            temp[25] = tempString;
        }
        return temp;
    }

        public void setCipherText(String text){
            this.cipherText = text.toUpperCase();
        }
        public String getCipherText () {
            return this.cipherText;
        }
    }