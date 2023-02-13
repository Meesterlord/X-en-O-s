import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which gamemode?");
        int antwoord = scanner.nextInt();
        Game game = new Game(antwoord);

    }
}
