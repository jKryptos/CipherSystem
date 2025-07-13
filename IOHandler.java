import java.io.*;

public class IOHandler {

    public String incomingTextFile() throws FileNotFoundException {
        String text = "";
        BufferedReader loadFile = new BufferedReader(new FileReader("plaintext.txt"));
            try{
                StringBuilder stringBuilder = new StringBuilder();
                String line = loadFile.readLine();
                if (line.equals("\n")){
                    line.replace("\n","");
                    System.out.println(" ");
                }

                while(line != null){
                    stringBuilder.append(line);
                    line = loadFile.readLine();
                }
                text = stringBuilder.toString();
            } catch (IOException e) {
                System.out.println("Could not load from file.");
            }
        return text;
    }
}
