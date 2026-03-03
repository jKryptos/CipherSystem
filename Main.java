public class Main {

    public static void main(String[] args) {

        ApplicationFactory factory = new ApplicationFactory();
        UI userInterface = factory.createUI();

        userInterface.startUI();
    }
}