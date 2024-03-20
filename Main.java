import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        programStart();
    }

    public static void programStart(){

        Key key = new Key();

        System.out.println("What is your key? ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        key.setKey(userInput);
        System.out.println("Your key is " + key.getKey());
        key.eraseKey();
        System.out.println("Your key is " + key.getKey());
    }
}