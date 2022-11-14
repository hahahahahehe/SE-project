package Jungle_game;

import java.util.ArrayList;
import java.util.List;

public class Model {

// Fields
    private String AuserName,BuserName;
    public String[][] board = new String[9][];
    //A:0 b:1
    private int[][][] pieceInfo = new int[2][8][2];
    private int win = -1;
    private int[] pieceNum = new int[]{8,8};

// Functions
    public String getAuserName() {
        return AuserName;
    }

    public void setAuserName(String auserName) {
        AuserName = auserName;
    }

    public String getBuserName() {
        return BuserName;
    }

    public void setBuserName(String buserName) {
        BuserName = buserName;
    }

    //board

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    //    initialize the game and all the pieces
    private int getUserIndex(String pieceName){
        if(pieceName.charAt(0) == 'A') return 0;
        if(pieceName.charAt(0) == 'B') return 1;
        return -1;
    }

    private int getRankIndex(String pieceName){
        return (pieceName.charAt(1) - '1');
    }

    public void init(){
        board= new String[][]{
                {"0A7", "0", "2", "3", "2", "0", "0A6"},
                {"0", "0A3", "0", "2", "0", "0A2", "0"},
                {"0A1", "0", "0A5", "0", "0A4", "0", "0A8"},
                {"0", "1", "1", "0", "1", "1", "0"},
                {"0", "1", "1", "0", "1", "1", "0"},
                {"0", "1", "1", "0", "1", "1", "0"},
                {"0B8", "0", "0B4", "0", "0B5", "0", "0B1"},
                {"0", "0B2", "0", "2", "0", "0B3", "0"},
                {"0B6", "0", "2", "3", "2", "0", "0B7"}
        };
        pieceInfo = new int[][][]{
            {{3,1},{2,6},{2,2},{3,5},{3,3},{1,7},{1,1},{3,7}},{{7,7},{8,2},{8,6},{7,3},{7,5},{9,3},{9,7},{7,1}}
        };
        pieceNum = new int[]{8,8};
        win = -1;
    }

    // The position is river/trap/den/land.
    // return a String represent position information
    // "RV" represents river, "TR" represents trap,
    // "DE" den, "  " land, "A1" piece
    public String posiInfo(int x, int y){
        return board[x-1][y-1];
    }


    private int userIndex(String userName){
        if(userName.equals(AuserName)) return 0;
        else if(userName.equals(BuserName) ) return 1;
        return -1;
    }
    // check is that any user fulfills the win condition
// list is empty: other side is win
// list is not empty: check whether chessmen stay in the den.
// In the den -> win, not in the den
// (1)	lose    (2)	win    (3)	not finish (4) unknown name
// return a string type to indicate the status
    public String winnerCheck(){
        if(win == -1) return "not finish";
        if(win == 0) return "A win";
        return "B win";
    }


    public String getLandIndex(String posiInfo){
        return posiInfo.substring(0, 1);
    }
    private String getPieceName(String posiInfo){
        if(posiInfo.length() < 2) return null;
        return posiInfo.substring(1);
    } 
    // return a Boolean value to check whether the position is available or not
    // jump, allow , not allow
    private String get_land(String pieceName){
        int[] a = piecesInfo(pieceName);
        return getLandIndex(posiInfo(a[0], a[1]));
    }
    public String posiCheck(int x, int y, String pieceName){
        String posi = posiInfo(x, y);
        String aland = get_land(pieceName);
        String land = getLandIndex(posi);
        String piece = getPieceName(posi);
        int up = getUserIndex(pieceName);
        int rp = getRankIndex(pieceName);
        int rp2 = 0; 
        if(rp == 0){
           if(piece == null) return "allow";
           if(up == getUserIndex(piece)) return "not allow";
           if(aland.equals("1")){
                if(land.equals("1")) return "allow";
                return "not allow";
           }
           if(land.equals("1")) return "allow";
           rp2 = getRankIndex(piece);
           if(rp2 == 0 || rp2 == 7) return "allow";
           return "not allow";
        }
        if(land.equals("1")){
            if(rp == 6 || rp == 5){
                if(piece == null) return "jump";
                return "not allow";
            }
            return "not allow";
        }
        if(land.equals("3")){
            if(up == 0 && x == 1) return "not allow";
            if(up == 1 && x == 9) return "not allow";
        }
        if(piece == null) return "allow";
        if(up == getUserIndex(piece)) return "not allow";
        if(land.equals("2")){
            return "allow";
        }
        rp2 = getRankIndex(piece);
        if(rp2 <= rp) return "allow";
        return "not allow";
    }

    // Check whether the pieces are in which position,
    // return a list with two integer (x,y)
    public int[] piecesInfo(String pieceName){
        return pieceInfo[getUserIndex(pieceName)][getRankIndex(pieceName)];
    }

    // check the available chessman which is still alive
    // return a list of string (name of piece)
    public List<String> alivePiecesCheck(String user){
        int nameIndex = userIndex(user);
        if(nameIndex == -1)return null;
        String userchar;
        if(nameIndex == 0) userchar = "A";
        else userchar = "B";
        List<String> alivePieceList = new ArrayList<String>();
        for(int i=0;i<8;++i){
            if(pieceInfo[nameIndex][i][0] != -1)alivePieceList.add(userchar + String.valueOf(i));
        }
        return alivePieceList;
    }

    private void setPosi(int x , int y , String content){
        board[x-1][y-1] = new String(content);
    }
//  move the corresponding piece to a new position
    public void move (String pieceName, int x , int y){
        int[] posi = new int[]{piecesInfo(pieceName)[0] , piecesInfo(pieceName)[1]};
        String aimInfo = posiInfo(x, y);
        String aland = get_land(pieceName);
        setPosi(posi[0], posi[1], aland);
        
        int a , b;
        a = getUserIndex(pieceName); b = getRankIndex(pieceName);
        pieceInfo[a][b][0] = x; pieceInfo[a][b][1] = y;
        
        if(getLandIndex(aimInfo).equals("3")){
            if(a == 0 && x == 9) win = 0;
            if(a==1 && x==1) win = 1;
        }
        
        if(getPieceName(aimInfo) == null){setPosi(x , y , aimInfo + pieceName);return;}
        remove(getPieceName(aimInfo));
        setPosi(x, y, getLandIndex(aimInfo) + pieceName);        
    }

//  left 0 right 1 up 2 down 3
    private static int[][] differs = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    public void move (String pieceName, int direction){
        int[] dif = differs[direction];
        int[] posi = piecesInfo(pieceName);
        int[] aim = new int[]{posi[0] + dif[0] , posi[1] + dif[1]};
        String a;
        while(true){
            if(aim[0] < 1 || aim[0] > 9 || aim[1]<1||aim[1]>7) return;
            a = posiCheck(aim[0], aim[1], pieceName); 
            if(a.equals("allow")){
                move(pieceName , aim[0] , aim[1]);
                return;
            }
            if(a.equals("not allow")){
                return;
            }
            if(a.equals("jump")){
                aim[0] += dif[0];
                aim[1] += dif[1];
                continue;
            }
        }
    }

//  remove the corresponding piece
    public void remove (String pieceName){
        int userIndex = getUserIndex(pieceName);
        int rankIndex = getRankIndex(pieceName);
        pieceInfo[userIndex][rankIndex][0] = -1; pieceInfo[userIndex][rankIndex][1] = -1;
        pieceNum[userIndex] -= 1;
        if(pieceNum[userIndex] == 0) win = 1-userIndex;
    }

}
