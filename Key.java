public class Key {

    private String keyWord;

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
}
