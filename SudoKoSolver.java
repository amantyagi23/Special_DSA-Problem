
class SudoKoSolver{
    static int board[][] = {
        {5,3,0,0,7,0,0,0,0}
    ,{6,0,0,1,9,5,0,0,0}
    ,{0,9,8,0,0,0,0,6,0},
    {8,0,0,0,6,0,0,0,3},
    {4,0,0,8,0,3,0,0,1},{7,0,0,0,2,0,0,0,6},
    {0,6,0,0,0,0,2,8,0},{0,0,0,4,1,9,0,0,5},
    {0,0,0,0,8,0,0,7,9}};

    
    
    static boolean canIPlaceValue(int row, int col, int val){
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

    static boolean solver(int row, int col){
        
        // Before Going in 1 to 9 Option Check that cell must be empty
        if(col == board.length){
            col = 0;
            row = row +1;
        }
        if(row == board.length){
            return true;
        }
        if(board[row][col]!=0){
            return  solver(row, col+1);
        }
        // There willbe a loop for 1 to 9 possiblity
        for(int value = 1; value<=9 ; value++  ){
            if(canIPlaceValue(row, col, value)){
                // Now value can be place 
                board[row][col] = value; // Place at cell
                boolean result  =  solver(row, col+1);
                if(result){
                    return true;
                }
                board[row][col] = 0; // BackTracking
            }
        }
        return false;
    }
    public static void main(String[] args) {
        boolean r = solver(0,0);
        System.out.println(r);
    }
}
