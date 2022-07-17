class Solution {
    int[][] dir = new int[][]{ {1,2}, {-1,2},{1,-2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp=new double[n][n][k+1];
        
       return find(n,k,row,column, dp);
    }
    
    public double find(int n, int k, int r, int c, double[][][] dp){
        
        // when knight goes outside, return 0
        if(r<0 || r>n-1 || c<0 || c>n-1){
            return 0;
        }
        //it it stays in, the count is 1;
        if(k==0)
            return 1;
        
        if(dp[r][c][k]!=0){
               return dp[r][c][k];
            } 
        
        double prob=0;
        for(int i=0;i<dir.length;i++){ 
           prob+= 0.125 * find(n,k-1,r+dir[i][0], c+dir[i][1], dp);
           dp[r][c][k] = prob; 
        }
        return prob;
    }
    
    
    
    
    public double findRecursive(int n, int k, int r, int c){
        // when knight goes outside, return 0
        if(r<0 || r>n-1 || c<0 || c>n-1){
            return 0;
        }
        //it it stays in, the count is 1;
        if(k==0)
            return 1;
        
        double prob=0;
        for(int i=0;i<dir.length;i++){
           prob+= 0.125 * findRecursive(n,k-1,r+dir[i][0], c+dir[i][1]);
        }
        return prob;
    }
}