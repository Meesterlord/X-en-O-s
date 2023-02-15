import java.util.Objects;

public class Bord {
    int gevuldeVakken;
    String[][] bord;
    public Bord(){
        gevuldeVakken = 0;
        bord = new String[3][3];
        vulMetLetter(" ");
    }
    public void vulMetLetter(String letter){
        for(int i = 0; i < bord.length; i++){
            for(int j = 0; j < bord.length; j++){
                bord[i][j] = letter;
            }
        }
    }
    public void print(){
        System.out.println("  1   2   3");
        System.out.println("-------------");
        for(int i = 0; i < (bord.length); i++){
            for(int j = 0; j < bord.length; j++){
                System.out.print("| " + bord[i][j] + " ");
            }
            System.out.println("| " + (i+1));
            System.out.println("-------------");
        }

    }
    public boolean winCondition(String a){
        if(Objects.equals(bord[0][0], a) && Objects.equals(bord[0][1], a) && Objects.equals(bord[0][2], a)){
            return true;
        }
        else if(Objects.equals(bord[1][0], a) && Objects.equals(bord[1][1], a) && Objects.equals(bord[1][2], a)){
            return true;
        }
        else if(Objects.equals(bord[2][0], a) && Objects.equals(bord[2][1], a) && Objects.equals(bord[2][2], a)){
            return true;
        }
        else if(Objects.equals(bord[0][0], a) && Objects.equals(bord[1][0], a) && Objects.equals(bord[2][0], a)){
            return true;
        }
        else if(Objects.equals(bord[0][1], a) && Objects.equals(bord[1][1], a) && Objects.equals(bord[2][1], a)){
            return true;
        }
        else if(Objects.equals(bord[0][2], a) && Objects.equals(bord[1][2], a) && Objects.equals(bord[2][2], a)){
            return true;
        }
        else if(Objects.equals(bord[0][0], a) && Objects.equals(bord[1][1], a) && Objects.equals(bord[2][2], a)){
            return true;
        }
        else return Objects.equals(bord[0][2], a) && Objects.equals(bord[1][1], a) && Objects.equals(bord[2][0], a);
    }


    public void setOnBord(String player, int x, int y){
        gevuldeVakken ++;
        bord[x][y] = player;
    }
}
