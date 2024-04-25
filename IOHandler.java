import java.io.*;

public class IOHandler {

    public String incomingTextFile() throws FileNotFoundException {
        String text = "";
        BufferedReader loadFile = new BufferedReader(new FileReader("plaintext.txt"));
            try{
                StringBuilder stringBuilder = new StringBuilder();
                String line = loadFile.readLine();

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

/*    public String outgoingTextFile() throws IOException {
        String text = "";
            try{




            } catch (IOException ioe) {
                System.out.println("Could not save to file.");
            }
        return null;
    }*/
}
