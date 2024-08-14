package N_Queens_Knights_Sudoku_leetCode;

public class N_Knights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        Knight(board,0,0,4);
    }
        static void Knight(boolean[][] board, int row,int col,int knights) {
            if (knights == 0) {
                display(board);
                System.out.println();
            }

            if( row == board.length - 1  && col == board[0].length){
                return;
            }
            if(col == board[0].length){
                Knight(board,row + 1,0,knights);
                return;
            }

            if (isSafe(board, row, col)) {
                board[row][col] = true;
                Knight(board, row ,col + 1 ,knights - 1);
                board[row][col] = false;
            }
            Knight(board, row ,col + 1 ,knights );
        }
        static void display(boolean[][] board){
            for(boolean[] row: board){
                for(boolean x : row){
                    if(x){
                        System.out.print(" K ");
                    }
                    else{
                        System.out.print(" . ");
                    }
                    //System.out.println();
                }
                System.out.println();
            }
            System.out.println();
        }
        static boolean isSafe(boolean[][] board, int r,int col){
            //up
            if(isValid(board,r - 2,col - 1))
            {
                if(board[r-2][col-1]){
                    return false;
                }

            }
            if(isValid(board,r - 2,col + 1))
            {
                if(board[r-2][col+1]){
                    return false;
                }
            }
            if(isValid(board,r - 1,col - 2))
            {
                if(board[r-1][col-2]){
                    return false;
                }
            }
            if(isValid(board,r - 1,col + 2))
            {
                if(board[r-1][col+2]){
                    return false;
                }
            }
            return true;
        }
        static boolean isValid(boolean[][] board,int r,int col) {
            if (r >= 0 && r < board.length && col >= 0 && col < board[0].length) {
                return true;
            }
            return false;
        }

}
