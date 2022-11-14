package Jungle_game;

import Jungle_game.src.Jungle_game.Model;

import java.util.Scanner;

public class Controller {
    public Model linkedModel = new Model();

    public void getuserAname(){
        String UserA;
        Scanner scanner = new Scanner(System.in);
        UserA = scanner.nextLine();
        linkedModel.setAuserName(UserA);
    }

    public void getuserBname(){
        String UserB;
        Scanner scanner = new Scanner(System.in);
        UserB = scanner.nextLine();
        linkedModel.setBuserName(UserB);
    }

//    Functions

//    check which command user entered
//    enter 1: jump to start game
//    enter 2: jump to user guide
//    enter 3: quit the software
    public void evalMenu(String userCommand){
        if(userCommand == null) {
            throw new IllegalArgumentException();
        }
    }

//     input "move piece direction" to check
//     whether user can move one piece to a certain place
//       or check whether a piece can capture another piece
//     e.g. move A1 1
    public boolean evalGame(String userCommand, String[][] board){
        if(board.length == 0 || board == null){
            throw new IllegalArgumentException();
        }
        boolean flag = true;
        return flag;
    }

}
