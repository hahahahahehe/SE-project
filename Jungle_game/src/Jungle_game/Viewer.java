package Jungle_game;
import java.util.List;
import java.util.Scanner;


public class Viewer {
    public Controller linkedController;
    Viewer testing = new Viewer();

    //    Functions

    //  Display the main menu for user to
    //    1. start the game(to username)
    //    2. Refer to the User guide
    //    3. exit game
    public void displayMenu(){
        loop: while (true){
            System.out.println("---------------Welcome to the Jungle Game!---------------");
            System.out.println("1: Play Game");
            System.out.println("2: Game Guide");
            System.out.println("3: Exit");
            System.out.println("Please input your option in integer:");
            Scanner scanner= new Scanner(System.in);
            String option = scanner.next();
            linkedController.evalMenu(option);
            switch (option){
                case "1":{
                    System.out.println("Play Game");
                    break;
                }
                case "2":{
                    displayUserGuide();
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
    }

//    display the user guide
    public void displayUserGuide(){
        boolean displayMenu = true;
        loop: while (true){
            Scanner scanner = new Scanner(System.in);
            while (displayMenu){
                System.out.println("displayUserGuide");
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
        if(board.length == 0 || board == null){
            throw new IllegalArgumentException();
        }
    }

//    display the control panel(with rule of the game) to user to operate
    public void displayControl(String userA, String userB, boolean isUserA){

    }

    public void displayAskUsername(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Plesae input Player 1 name:");
        System.out.println("Plesae input Player 2 name:");
    }

}
