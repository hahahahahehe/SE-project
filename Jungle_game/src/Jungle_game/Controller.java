package Jungle_game;



import javax.swing.text.View;
import java.util.Scanner;

public class Controller {
    public Model linkedModel = new Model();
    public Viewer linkedViewer = new Viewer();

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
    public void evalMenu(){

        linkedViewer.displayMenu(
                "---------------Welcome to the Jungle Game!---------------\n" +
                        "1: Play Game\n" +
                        "2: Game Guide\n" +
                        "3: Exit\n" +
                        "Please input your option in integer:\n"
        );
        Scanner scanner= new Scanner(System.in);
        String option = scanner.next();

        //linkedController.evalMenu(option);
        switch (option){
            case "1":{
                System.out.println("Play Game");
                linkedViewer.displayAskUsername();

                break;
            }
            case "2":{
                linkedViewer.displayUserGuide();
                break;
            }
            case "3":{
                System.out.println("Exit Now...");
                break;
            }
            default:{
                System.out.println("Please input the correct value");
            }
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
