import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueenProblemForLeetCodeP2 {
    
   static List<List<String>> result = new LinkedList<>();
    public static List<List<String>> solveNQueens(int n) {
        char[][] board =new char[n][n];
        for(char[] cs: board){
            Arrays.fill(cs, '.');
        }
        solverNqueen(board,0,0,n);
        return result;
    }
    public static void solverNqueen(char[][] board,int row,int col,int n){
            
            if(col==board.length){
                row = row+1;
                col = 0;
            }
            if(n==0){
                result.add(createstring(board));
            }
            if(row == board.length){
                return ;
            }
            for (int i = 0; i < board.length; i++) {
                if(checkplace(board,row,i)){

                    board[row][i] = 'Q';
                    n--;
                   solverNqueen(board,row+1,i,n);
                    board[row][i]='.';
                    n++;
                }
            }
            
        }


    public static boolean checkplace(char[][] board,int row,int col){
            for (int i = row; i>=0; i--) {
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

    public static List<String> createstring(char[][] board){
            List<String> res = new LinkedList<>();
       
        for (int i = 0; i < board.length; i++) {
            String dup = "";
            for (int j = 0; j < board.length; j++) {
                dup = dup+board[i][j]+"";
            }
            res.add(dup);
            // System.out.println();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

}
