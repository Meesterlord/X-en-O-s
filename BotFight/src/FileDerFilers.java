import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class FileDerFilers {
    ArrayList<String> profiles;
    public FileDerFilers() throws IOException {
        profiles = readFileIntoArray();
    }
    public void addIntoFile(String name) throws IOException {
        FileWriter fw = new FileWriter("BotFight/src/user.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name);
        bw.newLine();
        bw.close();
    }
    public void replaceStringInFile(String replaceString, String naam){
        try{
            for(int i = 0; i< profiles.size(); i++){
                if(naam.equals(profiles.get(i).split(";")[0])){
                    String data = profiles.get(i);
                    data = data.replace(profiles.get(i).split(";")[1], replaceString);
                    Files.writeString(Path.of(profiles.get(i)), data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> readFileIntoArray() throws IOException{
        ArrayList<String> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("BotFight/src/user.txt"))) {
            while (br.ready()) {
                result.add(br.readLine());
            }
        }
        return result;
    }
    public boolean IsProfileInFile(String naam, int getal){
        int waar = 0;
        for(int i = 0; i < profiles.size(); i++){
            if (naam.equals(profiles.get(i).split(";")[getal])) {
                waar = 1;
                break;
            }
        }
        return waar == 1;
    }
}
