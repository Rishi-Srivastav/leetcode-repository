class Solution {
    double mod;
    public int findPaths(int m, int n, int maxMove, int row, int col) {
        int[][][] dp = new int[m+1][n+1][maxMove+1];
        mod = 1e9 + 7;
            for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;k<=maxMove;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        
        return solve(m,n,maxMove,row, col, dp)%(int)mod;
    }
    
public int solve(int m, int n, int maxMove, int row, int col, int[][][] dp){
    if(maxMove < 0) return 0;
   
    if(row >= m || col >= n || row < 0 || col < 0) return 1;
    
    if(dp[row][col][maxMove] != -1) return dp[row][col][maxMove] % (int)mod;;
    
    long ans = 0;
    
    long left = solve(m, n, maxMove - 1, row, col - 1, dp) % (int)mod;
    long right = solve(m, n, maxMove - 1, row, col + 1, dp) %(int) mod;
    long up = solve(m, n, maxMove - 1, row - 1, col, dp) % (int)mod;
    long down = solve(m, n, maxMove - 1, row + 1, col, dp) % (int)mod;
    
    ans = (left + right + up + down) % (int)mod;
    return dp[row][col][maxMove] = (int)ans;
    
}
}