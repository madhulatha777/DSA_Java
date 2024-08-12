package N_Queens_Knights_Sudoku_leetCode;


public class N_Queens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(PlaceQueen(board,0));
    }

    static int PlaceQueen(boolean[][] board ,int r) {
        if(r == board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board[0].length; col++) {
            if(isSafe(board,r,col)){
                board[r][col] = true;
                count += PlaceQueen(board,r+1);
                board[r][col] = false;
            }
        }
        return  count;
    }

    static void display(boolean[][] board){
        for(boolean[] row : board){
            for(boolean element : row){
                if(element){
                    System.out.print("Q ");
                }
                else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    static boolean isSafe(boolean[][] board,int r,int col){

        // Vertical
        for (int i = 0; i < r; i++) {
            if(board[i][col]){
                return false;
            }
        }

        //Diagonal Left
        int MaxLeft = Math.min(r,col);
        for (int i = 1; i <= MaxLeft; i++) {
            if(board[r-i][col-i]){
                return false;
            }
        }

        //Diagonal Right
        int MaxLRight = Math.min(r,board.length - col-1);
        for (int i = 1; i <= MaxLRight; i++) {
            if(board[r-i][col+i]){
                return false;
            }
        }
        return true;
    }
}
