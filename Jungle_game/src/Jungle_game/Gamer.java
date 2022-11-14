package Jungle_game;

import java.lang.String;

public class Gamer {
//    Fields
    public static Model linkedModel = new Model();
    public static Viewer linkedViewer = new Viewer();
    public static Controller linkedController = new Controller();
//    public String currentState;

//    Functions
    public static void main(String[] args) {
        linkedController.evalMenu();

    }

}
