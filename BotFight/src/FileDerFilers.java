import java.io.*;
import java.util.ArrayList;

public class FileDerFilers {
    String[] profiles;
    public FileDerFilers(){
        profiles = new String[4];
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
}
