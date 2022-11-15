package Jungle_game;



import javax.swing.text.View;
import java.util.List;
import java.util.Scanner;

public class Controller{
    public Model linkedModel ;
    public Viewer linkedViewer;

    public String UserA, UserB;

    public Controller() {
    }

    public Controller(Model linkedModel, Viewer linkedViewer, String userA, String userB) {
        this.linkedModel = linkedModel;
        this.linkedViewer = linkedViewer;
        UserA = userA;
        UserB = userB;
    }

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


    /*Function: gameStart
    * Using while to ask user input until the user exit the game or any winner exist*/
    public void gameStart() {
        //Check is turn for User A(default is User A first)
        linkedModel.init();
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
            String option = scanner.next();


            switch (option) {
                case "1": {
                    linkedViewer.displayMovementPanel("Please input what pieces you want to move:");
                    String piecesChoose = scanner.next();
                    linkedViewer.displayMovementPanel("Please input the location you want to move:");
                    int directionChoose = scanner.nextInt();
                    //send pieces and direction to Model
                    //Update availablePieces
                    //Check Whether any user win the game
                    if(linkedModel.winnerCheck().equals("not finish")){
                        break ;
                    }else {
                        System.out.printf("Congratulations",linkedModel.winnerCheck());
                        break loop;
                    }
//                     if (linkedModel.winnerCheck(linkedModel.alivePiecesCheck())){
//                         return false;
//                     }
                }
                case "2": {
                    break loop;
                }
                default:{
                    linkedViewer.displayMenu("Please input the correct value in Integer");
                    break ;
                }
            }
        }


    }
}
