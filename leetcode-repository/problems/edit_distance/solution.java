class Solution {
    public int minDistance(String word1, String word2) {
        int min=word1.length();
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] cost = new int[n1+1][n2+1];
        
        for(int i=0;i<=n1;i++){
            cost[i][0]=i;
        }
        for(int i=0;i<=n2;i++){
            cost[0][i]=i;
        }
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                //if matching
                if(word1.charAt(i)==word2.charAt(j)){
                    cost[i+1][j+1]=cost[i][j];
                } else {
                int insert = cost[i][j+1] ;
                int replace = cost[i][j];
                int delete = cost[i+1][j];
                cost[i+1][j+1]=1+Math.min(insert, Math.min(replace, delete));    
                }
            }
        }
    return cost[n1][n2];
    }
}