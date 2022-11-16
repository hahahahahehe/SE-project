package Jungle_game;



import com.sun.jdi.IntegerValue;

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
//     1: jump to start game
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
        int vaildInput;

        loop:
        while (true) {

            if (isUserA == true) {
                //Change to User B turn
                isUserA = false;
                username = linkedModel.getBuserName();
                vaildInput = 1;
            } else {
                //Change to User A turn
                isUserA = true;
                username = linkedModel.getAuserName();
                vaildInput = 0;
            }

            linkedViewer.displayBoard(linkedModel.getBoard());
            String option;
            Scanner scanner = new Scanner(System.in);
            linkedViewer.displayMenu("Please input an Integer");
            do {
                linkedViewer.displayControl(username);
                option = scanner.nextLine();
            }while (validInputCheck(option) == false);



            switch (option) {
                case "1": {
                    String piecesChoose;
                    do {
                        linkedViewer.displayMovementPanel("Please input what pieces you want to move:");
                        piecesChoose = scanner.next().toUpperCase();
                    } while (vaildPiecesInput(piecesChoose, isUserA) == false);


                    String directionChoose;
                    do {
                        linkedViewer.displayMovementPanel("Please input the direction you want to move in Integer:");
                        linkedViewer.displayMovementPanel("left 0 right 1 up 2 down 3");
                        directionChoose = scanner.next();
                    } while (vaildDirectionInput(piecesChoose, directionChoose) == false);

                    //send pieces and direction to Model
                    //Update availablePieces
                    //Check Whether any user win the game
                    if (linkedModel.winnerCheck().equals("not finish")) {
                        break;
                    } else if(linkedModel.winnerCheck().equals("A win")){
                        System.out.printf("Congratulations", linkedModel.getAuserName());
                        break loop;
                    }else{
                        System.out.printf("Congratulations", linkedModel.getBuserName());
                        break loop;
                    }
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

    public boolean vaildPiecesInput(String userInput, boolean isUserA){
        int validInput = Model.getUserIndex(userInput);
        if(userInput.length()==2){
            int userInputInt = Integer.parseInt(String.valueOf(userInput.charAt(1)));
            if (  userInputInt <= 0 || userInputInt >= 9){
                linkedViewer.displayMovementPanel("You Should input the pieces in range 1-8!");
                return false;
            }
        }
        else {
            linkedViewer.displayMovementPanel("Please input the pieces correctly and in range 1-8 ! e.g A4");
            return false;
        }

        if(isUserA ) {
            switch (validInput){
                //0 represent the first char of user input is A
                case 0:{
                    linkedViewer.displayMovementPanel("Valid Input");
                    return true;
                }
                //1 represent the first char of user input is B
                case 1:{
                    linkedViewer.displayMovementPanel("Please move the A pieces only!");
                    return false;
                }
                default:
                    linkedViewer.displayMovementPanel("Please input the pieces correctly e.g A4");
                    return false;
            }
        }else {
            switch (validInput){
                //0 represent the first char of user input is A
                case 0:{
                    linkedViewer.displayMovementPanel("Please move the B pieces only!");
                    return false;
                }
                case 1:{
                    linkedViewer.displayMovementPanel("Valid Input");
                    return true;
                }
                default:
                    linkedViewer.displayMovementPanel("Please input the pieces correctly e.g A4");
                    return false;
            }

        }
    }
    public boolean vaildDirectionInput(String pieces, String directionChoose) {
        int directionChooseInt = Integer.parseInt(directionChoose);
        String ValidCheck = linkedModel.move(pieces, directionChooseInt);
        if (ValidCheck.equals("ok")) {
            return true;
        } else {
            linkedViewer.displayMovementPanel("");
            return false;
        }
    }

    public boolean validInputCheck(String option){
     switch (option){
         case "1":
         case "2":
             return true;
         default:{
             linkedViewer.displayMenu("Please input the Integer 1 or 2 correctly!");
             return false;
         }
     }
    }

}
