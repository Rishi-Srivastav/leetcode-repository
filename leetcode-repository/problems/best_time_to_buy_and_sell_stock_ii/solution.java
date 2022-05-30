class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] profits=new int[n];
        int dp = 0;
        int buy=prices[0];
        
        profits[0]=0;
        for(int i=1;i<n;i++){
            profits[i]= Math.max(0, prices[i]-buy);
            buy=Math.min(buy, prices[i]);
        }
        
        for(int i=1;i<n;i++){
            dp = dp  + Math.max(0, profits[i]-profits[i-1]);
        }
        return dp;
    }
}