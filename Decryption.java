public class Decryption {

    private String cipherText;

    final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

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
                } else if (binaryKeyArray[i] == '1') {
                    zeroCount = 0;
                    int position = alphaOne[oneCount].indexOf(cipherTextArray[i]);
                    char decryptedChar = ALPHABET.charAt(position);
                    cipherTextArray[i] = decryptedChar;
                    oneCount++;
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