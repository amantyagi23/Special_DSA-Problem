import java.util.LinkedList;
import java.util.List;

public class NQueenProblemForLeetCode {
    static List<List<String>> rest = new LinkedList<>();
    static char board [][] = {{'.','.','.','.','.'},
    {'.','.','.','.','.'},
    {'.','.','.','.','.'},
    {'.','.','.','.','.'},
    {'.','.','.','.','.'}};
    // TO check can we place a Queen
    static boolean canIPlaceAQueen(int row, int col){
        // Check on Above row
        for(int i = row; i>=0; i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        // Check in Right Diagonal
        for(int i = row , j=col; i>=0 && j<board.length; i--, j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        // Check in Left Diagonal
        for(int i = row , j=col; i>=0 && j>=0; i--, j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
}


// this function will return the number of possiblities
static int nQueenPlacement(int row, int col,int n){
    // Termination Case
    int count =0;
    if(col==board[0].length){
       
        col=0;
        row++;
    }
    if(n==0){
        
        rest.add(createstring(board));
    }
    if(row == board.length){
        return 1;
    }
    // Queen can be place on any col
    for(int i = 0 ; i<board.length;i++){
        
        if(canIPlaceAQueen(row, col)){
            board[row][i] = 'Q';
             // Queen Place
             n--;
            // Move to the Next Row
           count  = count+ nQueenPlacement(row+1, col,n);
             board[row][i] = '.';
             n++;
             // BackTrack and Undo It
            }
        }

        return count;
    }
    private static List<String> createstring(char[][] board) {
        List<String> dup = new LinkedList<>();
        String s ="45";
        for (char[] cs : board) {
            System.out.println(cs);
            dup.add(s);
        }
    return dup ;
}


// }
public static void main(String[] args) {
    int count = nQueenPlacement(0, 0,5);
    System.out.println(count);

    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board.length; j++) {
            System.out.print(board[i][j]);
        }
        System.out.println();
    }
    System.out.println("\n\n");
    System.out.println(rest);
}
}
