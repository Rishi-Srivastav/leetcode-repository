class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0], p=0;
        int n=prices.length;
        if(n==1) return 0;
        for(int i=1;i<n;i++){
            p=Math.max(p,prices[i]-buy);
            buy=Math.min(buy, prices[i]);
        }
        return p;
    }
}