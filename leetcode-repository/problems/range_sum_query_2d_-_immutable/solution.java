class NumMatrix {

    private int[][] cum;
    
    public NumMatrix(int[][] matrix) {
            if(   matrix           == null
       || matrix.length    == 0
       || matrix[0].length == 0   ){
        return;   
    }
        int m=matrix.length;
        int n=matrix[0].length;
        cum=new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                cum[i][j]=matrix[i][j]
                    +(i>=1?cum[i-1][j]:0)
                    +(j>=1?cum[i][j-1]:0)
                    -(i>=1 && j>=1?cum[i-1][j-1]:0);
            }
           }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return cum[row2][col2]-(row1>=1?cum[row1-1][col2]:0)
            -(col1>=1?cum[row2][col1-1]:0)+(row1>=1 && col1>=1?cum[row1-1][col1-1]:0);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */