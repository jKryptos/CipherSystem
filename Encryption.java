public class Encryption {

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
                int position = Alphabet.ALPHABET.indexOf(plainTextArray[i]);
                char encryptChar = getCharFromArray(alphaZero, position, zeroCount);
                plainTextArray[i] = encryptChar;
                zeroCount++;
                if (zeroCount >= Constants.VALUE_TO_SHIFT_AT){
                    alphaZero = Alphabet.arrayIndexShift(alphaZero, Constants.SHIFT_VALUE);
                }
            } else if (binaryKeyArray[i] == '1' && plainTextArray[i] != ' ') {
                zeroCount = 0;
                int position = Alphabet.ALPHABET.indexOf(plainTextArray[i]);
                char encryptChar = getCharFromArray(alphaOne, position, oneCount);
                plainTextArray[i] = encryptChar;
                oneCount++;
                if (oneCount >= Constants.VALUE_TO_SHIFT_AT){
                    alphaOne = Alphabet.arrayIndexShift(alphaOne, Constants.SHIFT_VALUE);
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
}
