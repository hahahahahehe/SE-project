package Jungle_game;

import java.lang.String;

public class Gamer {
//    Fields
    public Model linkedModel = new Model();
    public Viewer linkedViewer = new Viewer();
    public Controller linkedController = new Controller();
//    public String currentState;

//    Functions
    public void main(String[] args) {
        linkedController.evalMenu();
    }

}
