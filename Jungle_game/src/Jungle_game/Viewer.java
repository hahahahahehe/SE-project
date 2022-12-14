package Jungle_game;
import java.util.List;
import java.util.Scanner;


public class Viewer{
    public Controller linkedController ;

    public Viewer() {
    }

//    Functions

//  Display the main menu for user to
//    1. start the game(to username)
//    2. Refer to the User guide
//    3. exit game
    public void displayMenu(String content){
        System.out.println(content);
    }

    //    display the user guide
    public void displayUserGuide(){
        boolean displayMenu = true;
        loop: while (true){
            Scanner scanner = new Scanner(System.in);
            while (displayMenu){
                System.out.println("-------User Guide-------");
                System.out.println("XXXXXXXXXXXXXX");
                displayMenu =false;
            }
            System.out.println("-------Input Your Option-------");
            System.out.println("1. Return to menu");
            System.out.println("2. Read Again");
            String option = scanner.next();
            switch (option){
                case "1": {
                    System.out.println("Returning to the menu");
                    break loop;
                }
                case "2": {
                    displayMenu = true;
                    break ;
                }
                default:{
                    System.out.println("Please input the correct value");
                    displayMenu = false;
                }
            }

        }


    }

    //    display the (updated) chess board and pieces on it
//    a question: whether the string[][] board is public or not?
    public void displayBoard(String[][] board){

        for (String[] traverseRow : board) {
            for (String ind : traverseRow) {
                System.out.printf("|%4s|",ind);
            }
            System.out.println();
        }

    }

    //    display the control panel(with rule of the game) to user to operate
    public void displayControl(String username){
        System.out.printf("%s turn\n", username);
        System.out.println("1.Move");
        System.out.println("2.Exit the game");
//            System.out.printf("Please %s choose Your movement", username);
    }
    public void displayMovementPanel(String content){
        System.out.println(content);
    }

    public void displayAskUsername(){
        System.out.println("Please input UserA name:");
        linkedController.getuserAname();
        System.out.println("Please input UserB name:");
        linkedController.getuserBname();
    }

}
