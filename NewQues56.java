public class NewQues56 {
    
}
class Solution {
    public void solveSudoku(char[][] board) {
        
        solver(board,0,0);

        
    }
    public boolean solver(char[][] board, int row,int col){
        if(col == board.length){
            col = 0;
            row = row +1;
        }
        if(row == board.length){
            return true;
        }
        if(board[row][col]!='.'){
            return  solver(board,row, col+1);
        }
        // There willbe a loop for 1 to 9 possiblity
        for(char value = '1'; value<='9' ; value++  ){
            if(canIPlaceVal(board,row, col, value)){
                // Now value can be place 
                board[row][col] = value; // Place at cell
                boolean result  =  solver(board,row, col+1);
                if(result){
                    return true;
                }
                board[row][col] = '.'; // BackTracking
            }
        }
        return false;
        
    }
    public boolean canIPlaceVal(char[][] board,int row, int col, char val){
        // Check value in a row
        for (int i = 0; i <board.length; i++) {
            if(board[row][i]==val){
                return false;
            }
        }
        // check value in a column
        for (int i = 0; i < board.length; i++) {
            if(board[i][col]==val){
                return false;
            }
        }

        // check value in a sub grid
        int startrow = row - row %3;
        int startcol = col - col %3;
        for(int i = startrow;i<startrow+3; i++){
            for (int j = startcol; j < startcol+3; j++) {
                if(board[i][j]==val){
                    return false;
                }
            }
        }

        return true;

      

       
    }
}
