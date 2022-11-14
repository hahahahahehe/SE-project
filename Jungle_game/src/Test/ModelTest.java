package Test;


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
        assertEquals("A7",model.posiInfo(9,7)); // A's piece
        assertEquals("B3",model.posiInfo(2,2)); // B's piece
        assertEquals("TR",model.posiInfo(1,3)); // trap
        assertEquals("  ",model.posiInfo(5,4)); // land
        assertEquals("DE",model.posiInfo(1,4)); // den
    }

    @Test
    void winnerCheck() {
        // Both players have alive pieces
        List<String> alive1 = Arrays.asList("A1","A2","A3","A7","B1","B3","B6","B8");
        // Only Player A's pieces alive
        List<String> alive2 = Arrays.asList("A1","A2","A3","A4","A5","A6");
        // Only Player B's pieces alive
        List<String> alive3 = Arrays.asList("B1","B3","B6","B8");

        assertEquals("NF",model.winnerCheck(alive1)); // Not finish
        assertEquals("AWIN",model.winnerCheck(alive2)); // Player A wins
        assertEquals("BWIN",model.winnerCheck(alive3)); // Player B wins
    }

    @Test
    void posiCheck() {
        String P1 = "B1";
        String P2 = "A3";
        String P3 = "B7";
        String P4 = "A8";

        model.init();
        assertEquals(true,model.posiCheck(4,2,P1)); // B1 can move into river
        assertEquals(false,model.posiCheck(4,2,P2)); // A3 cannot move into river
        assertEquals(false,model.posiCheck(1,1,P2)); // A3 cannot capture B7
        assertEquals(true,model.posiCheck(9,1,P3)); // B7 can capture A6
        assertEquals(false,model.posiCheck(3,1,P3)); // B7 cannot capture B1
        assertEquals(false,model.posiCheck(1,4,P1)); // B1 cannot move to its own den
        assertEquals(true,model.posiCheck(9,4,P1)); // B1 can move to the opponent's den
        assertEquals(false,model.posiCheck(3,1,P4)); // A8 cannot capture B1
        assertEquals(true,model.posiCheck(7,1,P1)); // B1 can capture A8
    }

    @Test
    void move() {
        model.init();
        //move from land to land
        model.move("B1" , 2 , 1);
        assertEquals("B1",model.posiInfo(2,1));
        assertEquals(" ",model.posiInfo(3, 1));
        model.move("B1" , 3 , 1);
        //move from land to river
        model.move("B1" , 4 , 2);
        assertEquals("B1RV",model.posiInfo(4,2));
        assertEquals(" ",model.posiInfo(3, 1));
        //move from river to land
        model.move("B1" , 3 , 1);
        assertEquals("B1",model.posiInfo(3,1));
        assertEquals("RV",model.posiInfo(4, 2));
        //move from land to trap
        model.move("B1" , 1 , 3);
        assertEquals("B1TR",model.posiInfo(1,3));
        assertEquals(" ",model.posiInfo(3, 1));
        //move from trap to land
        model.move("B1" , 3 , 1);
        assertEquals("B1",model.posiInfo(3,1));
        assertEquals("TR",model.posiInfo(1, 3));
        //move from land to piece
        model.move("B1" , 7 , 1);
        assertEquals("B1",model.posiInfo(7,1));
        assertEquals(" ",model.posiInfo(3, 1));
        assertEquals(false , model.alivePiecesCheck().contains("A8"));
        //move from land to den
        model.move("B1" , 9 , 4);
        assertEquals("B1DE",model.posiInfo(9,4));
        assertEquals(" ",model.posiInfo(7, 1));
        assertArrayEquals(new int[]{9,4},model.piecesInfo("4A1"));
    }

    @Test
    void remove() {
        model.init();
        model.remove("A8");
        assertEquals(false , model.alivePiecesCheck().contains("A8"));
        assertEquals(" ",model.posiInfo(7,1));
    }
}