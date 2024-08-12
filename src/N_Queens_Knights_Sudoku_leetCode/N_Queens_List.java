package N_Queens_Knights_Sudoku_leetCode;

import java.util.ArrayList;
import java.util.List;

public class N_Queens_List {

    public static void main(String[] args) {

    }

    static List<List<String>> PlaceQueen(boolean[][] board, int r) {
        if (r == board.length) {
            List<List<String>> list = new ArrayList<>() ;

            List<String> innerlist = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                String p="";
                for (int j = 0; j < board[0].length; j++) {
                    if(board[i][j] == true){
                        p = p+"Q";
                    }
                    else{
                        p = p+".";
                    }
                }
                innerlist.add(p);
            }
            list.add(innerlist);
            return list;
        }
        List<List<String>> list = new ArrayList<>() ;
        int count = 0;
        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board, r, col)) {
                board[r][col] = true;
                list.addAll(PlaceQueen(board, r + 1));
                board[r][col] = false;
            }
        }
        return list;
    }


    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isSafe(boolean[][] board, int r, int col) {
        // Vertical
        for (int i = 0; i < r; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        //Diagonal Left
        int MaxLeft = Math.min(r, col);
        for (int i = 1; i <= MaxLeft; i++) {
            if (board[r - i][col - i]) {
                return false;
            }
        }

        //Diagonal Right
        int MaxLRight = Math.min(r, board.length - col - 1);
        for (int i = 1; i <= MaxLRight; i++) {
            if (board[r - i][col + i]) {
                return false;
            }
        }
        return true;
    }
}