class Solution {

    /**
    https://leetcode.com/problems/coin-change/discuss/77360/C++-O(n*amount)-time-O(amount)-space-DP-solution/81406
    **/
    
       public int coinChange(int[] coins, int amount) {
       int[] dp = new int[amount + 1];
       Arrays.fill(dp, amount + 1); 
       dp[0] = 0; 
       for(int j = 0; j < coins.length; j++){
         for(int i = 0; i <= amount; i++){
           if(i - coins[j] >= 0) dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); 
         } 
       } 
       return dp[amount] > amount ? -1 : dp[amount];
    }
    
      public int coinChangeRecursive(int[] coins, int amount) {
       Arrays.sort(coins);
       return coinMin(coins, amount, coins.length-1, 0); 
    }
    
    public int coinMin(int[] coins, int amount, int i, int count){
        if(amount==0){
            return count;
        }
        if(amount<0 || i<0){
            return -1;
        }
        
       int notadded = i-1>=0 ? coinMin(coins, amount, i-1, count) :-1;
       int added =  amount-coins[i]>=0 ? coinMin(coins, amount-coins[i], i, count+1) : -1;
       
       if(notadded==-1){
           count= added;
       } else if(added==-1){
           count= notadded;
       } else if(added!=-1 && notadded!=-1){
           count= Math.min(added, notadded);
       } else {
           count= -1;
       }
        return count;
    }
}

}
