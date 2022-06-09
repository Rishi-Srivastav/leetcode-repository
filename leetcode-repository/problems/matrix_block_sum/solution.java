class Solution {
    
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] rangeSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                rangeSum[i + 1][j + 1] = rangeSum[i + 1][j] + rangeSum[i][j + 1] - rangeSum[i][j] + mat[i][j];
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                int r1 = Math.max(0, i - K), c1 = Math.max(0, j - K), r2 = Math.min(m, i + K + 1), c2 = Math.min(n, j + K + 1);
                ans[i][j] = rangeSum[r2][c2] - rangeSum[r2][c1] - rangeSum[r1][c2] + rangeSum[r1][c1];
            }
        return ans;
    }
    
    
    
 // Brute force   
//     public int[][] matrixBlockSum(int[][] mat, int k) {
//         int m=mat.length;
//         int n=mat[0].length;
        
//         int[][] answer = new int[m][n];
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 //System.out.println(i +", "+j);
//                 for(int a=Math.max(0, i-k); a<= Math.min(m-1, i+k);a++){
//                     for(int b=Math.max(0, j-k); b<= Math.min(n-1, j+k);b++){
//                         // System.out.println(i +", "+j);
//                         answer[i][j]=answer[i][j]
//                             + mat[a][b];
//                     }
//                 }
//             }
//         }
        
//         return answer;
//     }
}