class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
    
    public int changeRecursive(int amount, int[] coins) {
        return change(amount, 0, coins);    
    }
    private int change(int balance, int cur, int[] coins) {
        if(balance == 0) return 1;
        if(balance<0 || cur == coins.length) return 0;
        return change(balance-coins[cur], cur, coins) + change(balance, cur+1, coins);
    }
}
