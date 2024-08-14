package N_Queens_Knights_Sudoku_leetCode;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}};

        sudoku(board,0,0);

        for(char[] arr : board){
            for(char digit:arr){
                System.out.print(digit);
            }
            System.out.println();
        }
    }
    static boolean sudoku(char[][] board,int row,int col){
        if(row == board.length-1 && col == board[0].length){
//            for (int i = 0; i < 8; i++) {
//                for (int j = 0; j < 8; j++) {
//                    System.out.print(board[i][j]);
//                }
//                System.out.println();
//            }
            return true;
        }
        if(col == board[0].length){

            return sudoku(board,row+1,0);
        }
        if(board[row][col] == '.'){
            for (int i = 1; i <= 9; i++) {
                if(isSafe(board,row,col,(i+"").charAt(0))){
                    board[row][col] = (i+"").charAt(0);
                    boolean ans = sudoku(board,row,col+1);
                    if(ans){
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
        }
        else{
          return sudoku(board,row,col+1);
        }
        return false;
    }
    static boolean isSafe(char[][] board , int row,int col,char num){
        for (int i = 0; i <= 8; i++) {
            if(board[row][i] == num){
                return false;
            }
        }
        for (int i = 0; i <= 8; i++) {
            if(board[i][col] == num){
                return false;
            }
        }
        for (int i = (row/3)*3; i < (row/3)*3+3; i++) {
            for (int j = (col/3)*3; j < (col/3)*3+3; j++) {
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
