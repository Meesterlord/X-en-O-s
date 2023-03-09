import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ProfileChooser {
    public ProfileChooser(){}
    public void startGame() throws IOException, InterruptedException {
        FileDerFilers file = new FileDerFilers();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you already have an account? \n1. yes \n2. no ");
        String antwoord = scanner.nextLine();
        if(antwoord.equals("yes") || antwoord.equals("1")){
            System.out.println("What is your profile?");
            antwoord = scanner.nextLine();
            if(file.IsProfileInFile(antwoord)){
                System.out.println("Profile Found");
                System.out.println("GREAT! Let's play!");
                Player playerYou = new Player(antwoord,1);
                Player playerTwo = new Player("Guest",2);
                Game game = new Game(1);
                game.player1 = playerYou;
                game.player2 = playerTwo;
            }
            else{
                System.out.println("Profile Doesn't Exist");
                System.out.println("you are a fucking liar");
            }
        }
        else if(antwoord.equals("no") || antwoord.equals("2")){
            System.out.println("Let's make one then!");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("What is your name?");
            antwoord = scanner.nextLine();
            if(file.IsProfileInFile(antwoord)){
                System.out.println("This profile already exists!!!");
            }
            else {
                file.addIntoFile(antwoord +":0");
                System.out.println("Profile has been added into the list");
            }
        }
    }
}