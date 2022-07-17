class Solution {
public:
int mod = 1e9 + 7;

int solve(int m, int n, int maxMove, int row, int col, vector<vector<vector<int>>> &dp){
    if(maxMove < 0) return 0;
   
    if(row >= m || col >= n || row < 0 || col < 0) return 1;
    
    if(dp[row][col][maxMove] != -1) return dp[row][col][maxMove] % mod;;
    
    long ans = 0;
    
    long left = solve(m, n, maxMove - 1, row, col - 1, dp) % mod;
    long right = solve(m, n, maxMove - 1, row, col + 1, dp) % mod;
    long up = solve(m, n, maxMove - 1, row - 1, col, dp) % mod;
    long down = solve(m, n, maxMove - 1, row + 1, col, dp) % mod;
    
    ans = (left + right + up + down) % mod;
    return dp[row][col][maxMove] = (int)ans;
    
}

int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    vector<vector<vector<int>>> dp(m + 1, vector<vector<int>>(n + 1, vector<int>(maxMove + 1, -1)));
    return solve(m, n, maxMove, startRow, startColumn, dp) % mod;
    
}
};