class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp = new int[m][n];     
        int max=0;
        for(int i=0;i<m;i++){
            dp[i][0]=Character.getNumericValue(matrix[i][0]);
            max=Math.max(dp[i][0], max);
        }
        
        for(int j=0;j<n;j++){
            dp[0][j]=Character.getNumericValue(matrix[0][j]);
            max=Math.max(dp[0][j], max);
        }
  
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='1'){
                     dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                } else {
                    dp[i][j]=Character.getNumericValue(matrix[i][j]);
                }
               // System.out.print(dp[i][j] + ", ");
                max=Math.max(max, dp[i][j]);
            }
          //  System.out.println();
        }
        return max*max;
    }
}