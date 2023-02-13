public class Player {
    String name;
    String placeHolder;
    int playerNumber;
    public Player(String name, int playerNumber){
        this.name = name;
        this.playerNumber = playerNumber;
        if(playerNumber == 1){
            placeHolder = "X";
        }
        else{
            placeHolder = "O";
        }
    }

    public String getName() {
        return name;
    }
    public String getPlaceHolder() {
        return placeHolder;
    }
}
