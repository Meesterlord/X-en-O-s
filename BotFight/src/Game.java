import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    int gameMode;
    Bord bord;
    Player player1;
    Player player2;
    boolean win;
    public Game(int gamemode){
        this.win = false;
        this.gameMode = gamemode;
        bord = new Bord();
        gameModeChoice();
    }
    public void gameModeChoice(){

        if(gameMode == 1){
            humanVShuman();
        }
        else{
            System.out.println("ERROR");
        }
    }
    public void humanVShuman(){
        int turn = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name player 1?");
        String antwoord = scanner.nextLine();
        player1 = new Player(antwoord, 1);
        System.out.println("What is your name player 2?");
        antwoord = scanner.nextLine();
        player2 = new Player(antwoord, 2);
        System.out.println(player1.getName() + " VS " + player2.getName());
        System.out.println(player1.getName() + " = " + player1.getPlaceHolder());
        System.out.println(player2.getName() + " = " + player2.getPlaceHolder());
        System.out.println(player1.getName() + " Starts");
        bord.print();

        while(!win){
            int getal1 ;
            int getal2 ;
            if(turn == 1){
                System.out.println(player1.getName() +":");
                boolean notLetter = false;
                while(!notLetter) {
                    try {
                        Scanner cin = new Scanner(System.in);
                        getal1 = (cin.nextInt() - 1);
                        getal2 = (cin.nextInt() - 1);
                        if(!bord.bord[getal2][getal1].equals(" ")){
                            System.out.println("Something is there already");
                            bord.print();
                        }
                        else{
                            bord.setOnBord(player1.getPlaceHolder(), getal2, getal1);
                            bord.print();
                            win = bord.winCondition(player1.getPlaceHolder());
                            turn = 2;
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
                    }
                }

            }
            else if(turn == 2){
                System.out.println(player2.getName() + ":");
                boolean notLetter = false;
                while(!notLetter) {
                    try {
                        Scanner cin = new Scanner(System.in);
                        getal1 = (cin.nextInt() - 1);
                        getal2 = (cin.nextInt() - 1);
                        if(!bord.bord[getal2][getal1].equals(" ")){
                            System.out.println("Something is there already");
                        }

                        else{
                            bord.setOnBord(player2.getPlaceHolder(), getal2, getal1);
                            bord.print();
                            win = bord.winCondition(player2.getPlaceHolder());
                            turn = 1;
                        }
                        notLetter = true;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Fill in a NUMBER!");
                        bord.print();
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("From 1 to 3 PLEASE!!!");
                        bord.print();
                    }
                }
            }
            else{
                System.out.println("ERROR?????");
            }

        }
    }
}
