package Jungle_game;


import Jungle_game.Model;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    Model model = new Model();

    @Test
    void init() {
        assertNull(model.board[0]);
        model.init();
        assertNotNull(model.board);
        assertNotNull(model.board[0]);
    }

    @Test
    void posiInfo() {
        model.init();
        assertEquals("0B7",model.posiInfo(9,7)); // A's piece
        assertEquals("0A3",model.posiInfo(2,2)); // B's piece
        assertEquals("2",model.posiInfo(1,3)); // trap
        assertEquals("0",model.posiInfo(5,4)); // land
        assertEquals("3",model.posiInfo(1,4)); // den
    }

    @Test
    void winnerCheck() {
        // Both players have alive pieces
        List<String> alive1 = Arrays.asList("A1","A2","A3","A7","B1","B3","B6","B8");
        // Only Player A's pieces alive
        List<String> alive2 = Arrays.asList("A1","A2","A3","A4","A5","A6");
        // Only Player B's pieces alive
        List<String> alive3 = Arrays.asList("B1","B3","B6","B8");
        model.init();
        assertEquals("not finish",model.winnerCheck());// Not finish
        model.move("B1" , 1 ,4);
        assertEquals("B win",model.winnerCheck()); // Player B wins
        model.init();
        model.move("A1" , 9 ,4);
        assertEquals("A win",model.winnerCheck()); // Player A wins
    }

    @Test
    void posiCheck() {
        String P1 = "A1";
        String P2 = "B3";
        String P3 = "A7";
        String P4 = "B8";

        model.init();
        assertEquals("allow",model.posiCheck(4,2,P1)); // A1 can move into river
        assertEquals("not allow",model.posiCheck(4,2,P2)); // A3 cannot move into river
        assertEquals("not allow",model.posiCheck(1,1,P2)); // A3 cannot capture B7
        assertEquals("allow",model.posiCheck(9,1,P3)); // A7 can capture B6
        assertEquals("not allow",model.posiCheck(3,1,P3)); // A7 cannot capture A1
        assertEquals("not allow",model.posiCheck(1,4,P1)); // A1 cannot move to its own den
        assertEquals("allow",model.posiCheck(9,4,P1)); // A1 can move to the opponent's den
        assertEquals("not allow",model.posiCheck(3,1,P4)); // B8 cannot capture A1
        assertEquals("allow",model.posiCheck(7,1,P1)); // A1 can capture B8
    }

    @Test
    void move() {
        model.init();
        //move from land to land
        assertEquals("0",model.getLandIndex("0A1"));
        model.move("A1" , 2 , 1);
        assertEquals("0A1",model.posiInfo(2,1));
        assertEquals("0",model.posiInfo(3, 1));
        model.move("A1" , 3 , 1);
        //move from land to river
        model.move("A1" , 4 , 2);
        assertEquals("1A1",model.posiInfo(4,2));
        assertEquals("0",model.posiInfo(3, 1));
        //move from river to land
        model.move("A1" , 3 , 1);
        assertEquals("0A1",model.posiInfo(3,1));
        assertEquals("1",model.posiInfo(4, 2));
        //move from land to trap
        model.move("A1" , 1 , 3);
        assertEquals("2A1",model.posiInfo(1,3));
        assertEquals("0",model.posiInfo(3, 1));
        //move from trap to land
        model.move("A1" , 3 , 1);
        assertEquals("0A1",model.posiInfo(3,1));
        assertEquals("2",model.posiInfo(1, 3));
        //move from land to piece
        model.setBuserName("B");
        model.move("A1" , 7 , 1);
        assertEquals("0A1",model.posiInfo(7,1));
        assertEquals("0",model.posiInfo(3, 1));
        assertEquals(false , model.alivePiecesCheck("B").contains("B8"));
        //move from land to den
        model.move("A1" , 9 , 4);
        assertEquals("3A1",model.posiInfo(9,4));
        assertEquals("0",model.posiInfo(7, 1));
    }

    @Test
    void remove() {
        model.init();
        model.setAuserName("A");
        model.remove("A8");
        assertEquals(false , model.alivePiecesCheck("A").contains("A8"));
    }
}