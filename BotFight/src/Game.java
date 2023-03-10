import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    int gameMode;
    Bord bord;
    Player player1;
    Player player2;
    boolean win;
    public Game(){
        this.win = false;
    }
    public void gameModeChoice(int number){
        this.gameMode = number;
        if(gameMode == 1){
            humanVShuman();
        }
        else if(gameMode == 2){
            humanVSbot();
        }
        else{
            System.out.println("ERROR");
        }
    }
    public void humanVSbot(){
        System.out.println("Is nog in werking");
    }

    public void humanVShuman(){
        int turn = 1;
        bord = new Bord();
        Scanner scanner = new Scanner(System.in);
        String antwoord;
        System.out.println(player1.getName() + " VS " + player2.getName());
        System.out.println(player1.getName() + " = " + player1.getPlaceHolder());
        System.out.println(player2.getName() + " = " + player2.getPlaceHolder());
        System.out.println(player1.getName() + " Starts");
        bord.print();

        while(!win){
            if(turn == 1){
                if(playerTurnPlay(player1)){
                    turn = 2;
                }
            }
            else if(turn == 2){
                if(playerTurnPlay(player2)){
                    turn = 1;
                }
            }
            else{
                System.out.println("ERROR?????");
            }

        }
        System.out.println("Again?");
        antwoord = scanner.nextLine();
        if(antwoord.equals("Yes") || antwoord.equals("yes")){
            humanVShuman();
        }
        else {
            System.out.println("Until the next time then");
        }

    }
    public void wieWin(boolean eind, int speler) throws IOException {
        if(eind){
            if(speler == 1){
                System.out.println(player1.getName() + " WON!!!!!!");
                FileDerFilers file = new FileDerFilers();
                file.replaceStringInFile("20",player1.getName());
            }
            else{
                System.out.println(player2.getName() + " WON!!!!!!");
            }
        }
    }
    public boolean playerTurnPlay(Player players){
        System.out.println(players.getName() +":");
        boolean notLetter = false;
        while(!notLetter) {
            try {
                Scanner cin = new Scanner(System.in);
                int getal1 = (cin.nextInt() - 1);
                int getal2 = (cin.nextInt() - 1);
                if(!bord.bord[getal2][getal1].equals(" ")){
                    System.out.println("Something is there already");
                    bord.print();
                }
                else{
                    bord.setOnBord(players.getPlaceHolder(), getal2, getal1);
                    bord.print();
                    win = bord.winCondition(players.getPlaceHolder());
                    wieWin(win, 1);
                    if(bord.gevuldeVakken == 9){
                        System.out.println("IT'S A DRAW");
                        win = true;
                    }
                    return true;
                }
                notLetter = true;
            }
            catch (InputMismatchException e) {
                System.out.println("Fill in a NUMBER!");
                bord.print();
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("From 1 to 3 PLEASE!!");
                bord.print();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
