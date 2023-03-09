import java.io.*;
import java.util.ArrayList;

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
    public ArrayList<String> readFileIntoArray() throws IOException{
        ArrayList<String> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("BotFight/src/user.txt"))) {
            while (br.ready()) {
                result.add(br.readLine());
            }
        }
        return result;
    }
    public boolean IsProfileInFile(String naam){
        int waar = 0;
        for(int i = 0; i < profiles.size(); i++){
            if(naam.equals(profiles.get(i).split(":")[0])){
                waar = 1;
            }
        }
        if(waar == 1){
            return true;
        }
        else{
            return false;
        }
    }
}
