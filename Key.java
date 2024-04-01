public class Key {

    private String keyWord;
    private String binaryKey;

    public Key(){

    }
    public void setKey(String key){
        this.keyWord = key;
    }
    public String getKey(){
        return this.keyWord;
    }
    public void eraseKey(){
        this.keyWord = null;
        System.out.println("Key erased!");
    }
    public String stringToBinaryCodeReturn(String stringToConvert){

        byte[] bytes = stringToConvert.getBytes();
        StringBuilder binaryOutput = new StringBuilder();

        for (byte b : bytes){
            int val = b;
            for (int i = 0; i < 8;i++){
                binaryOutput.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        return binaryOutput.toString();
    }
    public void setBinaryKey(String binaryKey) {
        this.binaryKey = binaryKey;
    }
    public String getBinaryKey(){
        return this.binaryKey;
    }
}
