public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] cost = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)
            cost[i][0] = i;
        for(int i = 1; i <= n; i++)
            cost[0][i] = i;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    cost[i + 1][j + 1]++;
                }
            }
        }
        return cost[m][n];
    }
    
    /** My Recursive Solution - 
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if(m==0)
            return n;
        
        if(n==0)
            return m;
        
        if(word1.charAt(0)==word2.charAt(0)){
            return minDistance(word1.substring(1), word2.substring(1));
        }
        
        int insert=1+minDistance(word1, word2.substring(1));
        
        int delete= 1+minDistance(word1.substring(1), word2);
        
        int replace=1+minDistance(word1.substring(1), word2.substring(1));
        
        return Math.min(insert, Math.min(delete, replace));
    }
}
    
    **/
}
