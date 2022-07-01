class Solution {
    //0-1 knapsack problem
    // one time include ith element, 2nd time don't include
    public int change(int amount, int[] coins) {
        if(amount==0)
            return 1;
        int[][] k = new int[coins.length+1][amount+1];
        k[0][0]=1;
        for(int i=1;i<=coins.length;i++){
            k[i][0]=1;
            for(int j=1;j<=amount;j++){
                k[i][j]=  k[i-1][j] + (j>=coins[i-1]? k[i][j-coins[i-1]] : 0);
            }
        }
        return k[coins.length][amount];
}
}