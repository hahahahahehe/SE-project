package Jungle_game;
import java.util.List;
import java.util.Scanner;


public class Viewer {
    public static Controller linkedController = new Controller();
    public static Model linkedModel = new Model();

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

        System.out.println(board);
        if(board.length == 0 || board == null){
            throw new IllegalArgumentException();
        }
    }

    //    display the control panel(with rule of the game) to user to operate
    public void displayControl(String username){
        System.out.printf("%s turn\n", username);
        System.out.println("1.Move\n");
        System.out.println("2.Exit the game\n");
//            System.out.printf("Please %s choose Your movement", username);
    }
    public void displayMovementPanel(String content){
        displayMovementPanel(content);
    }

    public void displayAskUsername(){
        System.out.println("Please input UserA name:");
        linkedController.getuserAname();
        System.out.println("Please input UserB name:");
        linkedController.getuserBname();
    }

}
