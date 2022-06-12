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

}