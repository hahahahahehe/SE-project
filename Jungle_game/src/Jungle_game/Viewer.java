package Jungle_game;
import java.util.List;


public class Viewer {

    //    Functions

//  Display the main menu for user to
//    1. start the game(to username)
//    2. Refer to the User guide
//    3. exit game
    public void displayMenu(){

    }

//    display the user guide
    public void displayUserGuide(){

    }

//    display the (updated) chess board and pieces on it
//    a question: whether the string[][] board is public or not?
    public void displayBoard(String[][] board){
        if(board.length == 0 || board == null){
            throw new IllegalArgumentException();
        }
    }

//    display the control panel(with rule of the game) to user to operate
    public void displayControl(String userA, String userB, boolean isUserA){

    }

}
