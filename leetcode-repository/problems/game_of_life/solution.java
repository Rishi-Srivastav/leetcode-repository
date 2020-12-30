class Solution {

   public static void gameOfLife(int[][] board) {
		int m = board.length;
		int n = (m>=1)?board[0].length:0;
		int result[][] = new int[m][n];

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				int val = checkAtIndex(i,j,board);

				if(val == 3){
					result[i][j] = 1;
				} else if(board[i][j]==1 && (val >3 || val<2)){
					result[i][j] = 0;
				} else {
					result[i][j]= board[i][j];
				}
			}              
		}

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				board[i][j] = result[i][j];
				//System.out.println(board[i][j]);
			}
		}

	}
                          
                          
    public static int checkAtIndex(int i, int j, int[][] board){
        return getValue(board, i-1, j-1)+ getValue(board, i-1, j)+ getValue(board, i-1, j+1)
            +getValue(board, i,j+1) + getValue(board, i+1, j+1)+ getValue(board, i+1, j)
            +getValue(board, i+1, j-1) + getValue(board, i, j-1);
    }
    
    public static int getValue(int[][] board, int a, int b){
        int r = 0;
        try{
            r+=board[a][b];
            return r;
        } catch(Exception e){
            return r;
        }
    }
}