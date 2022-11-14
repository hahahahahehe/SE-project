package Jungle_game;



import javax.swing.text.View;
import java.util.List;
import java.util.Scanner;

public class Controller extends Gamer {
    public String UserA, UserB;


    public void getuserAname() {

        Scanner scanner = new Scanner(System.in);
        UserA = scanner.nextLine();
        linkedModel.setAuserName(UserA);
    }

    public void getuserBname() {
        Scanner scanner = new Scanner(System.in);
        UserB = scanner.nextLine();
        linkedModel.setBuserName(UserB);
    }

//    Functions

    //    check which command user entered
//    enter 1: jump to start game
//    enter 2: jump to user guide
//    enter 3: quit the game
    public void evalMenu() {
        loop:
        while (true) {
            linkedViewer.displayMenu(
                    "---------------Welcome to the Jungle Game!---------------\n" +
                            "1: Play Game\n" +
                            "2: Game Guide\n" +
                            "3: Exit\n" +
                            "Please input your option in integer:\n"
            );
            Scanner scanner = new Scanner(System.in);
            String option = scanner.next();

            //linkedController.evalMenu(option);
            switch (option) {
                case "1": {
                    linkedViewer.displayMenu("Play Game");
                    linkedViewer.displayAskUsername();
                    gameStart();
                    break;
                }
                case "2": {
                    linkedViewer.displayUserGuide();
                    break;
                }
                case "3": {
                    linkedViewer.displayMenu("Exit Now...");
                    break loop;
                }
                default: {
                    linkedViewer.displayMenu("Please input the correct value");
                }
            }
        }

    }

    /* evalGameFunction
    Check whether still in the game status
    */
    public boolean evalGame() {
        boolean flag = true;
        //Check whether user win or not
        return flag;
    }

    public void gameStart() {
        //Check is turn for User A(default is User A first)
        boolean isUserA = false;
        String username;

        loop:
        while (true) {

            if (isUserA == true) {
                isUserA = false;
                username = linkedModel.getBuserName();
            } else {
                isUserA = true;
                username = linkedModel.getAuserName();
            }

            linkedViewer.displayBoard(linkedModel.getBoard());
            linkedViewer.displayControl(username);

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1: {
                    linkedViewer.displayMenu("Please input what pieces you want to move:");
                    String piecesChoose = scanner.next();
                    linkedViewer.displayMenu("Please input which direction you want to move:");
                    int directionChoose = scanner.nextInt();
                    //send pieces and direction to Model
                    //Update availablePieces
                    //Check Whether still in the game status
                    if(evalGame()){
                        break loop;
                    }else {
                        break;
                    }
//                     if (linkedModel.winnerCheck(linkedModel.alivePiecesCheck())){
//                         return false;
//                     }
                }
                case 2: {
                    break loop;
                }
            }
        }


    }
}
