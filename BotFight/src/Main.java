import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
       /* Scanner scanner = new Scanner(System.in);
        System.out.println("Which gamemode?");
        int antwoord = scanner.nextInt();
        Game game = new Game(antwoord);*/

        FileDerFilers file = new FileDerFilers();
        ArrayList<String> arl;
        arl = file.readFileIntoArray();
        for (int i = 0; i < arl.size(); i++) {
            System.out.println(arl.get(i) + " ");
        }

    }

}
