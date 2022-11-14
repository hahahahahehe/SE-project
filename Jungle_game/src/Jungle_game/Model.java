package Jungle_game;

import java.util.ArrayList;
import java.util.List;

public class Model {

// Fields
    private String AuserName,BuserName;
    public String[][] board = new String[9][];

// Functions

    //    get both user’s name
    private void getUsername(){

    }

    public String getAuserName() {
        return AuserName;
    }

    public void setAuserName(String auserName) {
        AuserName = auserName;
    }

    public String getBuserName() {
        return BuserName;
    }

    public void setBuserName(String buserName) {
        BuserName = buserName;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    //    initialize the game and all the pieces
    public void init(){

    }

    // The position is river/trap/den/land.
    // return a String represent position information
    // "1" represents river, "2" represents trap,
    // "3" den, "4" land, "5A1" piece
    public String posiInfo(int x, int y){
        String posi= new String();
        return posi;
    }

    // check is that any user fulfills the win condition
// list is empty: other side is win
// list is not empty: check whether chessmen stay in the den.
// In the den -> win, not in the den
// (1)	lose    (2)	win    (3)	not finish
// return a string type to indicate the status
    public String winnerCheck(List availablePieces){
        String status = new String();
        return status;
    }

    // return a Boolean value to check whether the position is available or not
    public boolean posiCheck(int x, int y, String pieceName){
        boolean result = false;
        return result;
    }

    // Check whether the pieces are in which position,
    // return a list with two integer (x,y)
    public int[] piecesInfo(String pieceName){
        int[] coordinator=new int[2];
        return coordinator;
    }

    // check the available chessman which is still alive
    // return a list of string (name of piece)
    public List<String> alivePiecesCheck(){
        List<String> alivePieceList = new ArrayList<String>();
        return alivePieceList;
    }

//  move the corresponding piece to a new position
    public void move (String pieceName, int x , int y){
    }

//  remove the corresponding piece
    public void remove (String pieceName){

    }

}
