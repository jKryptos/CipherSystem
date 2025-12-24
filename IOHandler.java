import java.io.*;

public class IOHandler {

    public String incomingTextFile(String textFileName) {
        String text = "";
        try (BufferedReader loadFile = new BufferedReader(new FileReader(textFileName))){

            StringBuilder stringBuilder = new StringBuilder();
            String line = loadFile.readLine();
                while(line != null){
                    stringBuilder.append(line);
                    line = loadFile.readLine();
                }
                text = stringBuilder.toString();
        } catch (IOException e){
            return null;
        }
        return text;
    }
}
