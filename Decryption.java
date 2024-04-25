public class Decryption {

    private String cipherText;

    final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Decryption(){

    }
    public String decryptText(String cipherText, String binaryKey, String alphaZero, String alphaOne) {

        char[] cipherTextArray = cipherText.toCharArray();

        while (binaryKey.length() < cipherTextArray.length) {
            binaryKey += binaryKey;
        }
        char[] binaryKeyArray = binaryKey.toCharArray();

        for (int i = 0; i < cipherTextArray.length; i++) {
            if (cipherTextArray[i] != ' ') {
                if (binaryKeyArray[i] == '0') {
                    int position = alphaZero.indexOf(cipherTextArray[i]);
                    char decryptedChar = ALPHABET.charAt(position);
                    cipherTextArray[i] = decryptedChar;
                } else if (binaryKeyArray[i] == '1') {
                    int position = alphaOne.indexOf(cipherTextArray[i]);
                    char decryptedChar = ALPHABET.charAt(position);
                    cipherTextArray[i] = decryptedChar;
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