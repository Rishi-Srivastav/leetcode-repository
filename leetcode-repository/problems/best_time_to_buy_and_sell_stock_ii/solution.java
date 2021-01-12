class Solution {
    public int maxProfit(int[] prices) {
        int max =0, n=prices.length;
        if(n<2)
            return 0;
        for(int i=1;i<n;i++){
            if(prices[i]>prices[i-1])
                max+=prices[i]-prices[i-1];
        }
        return max;
 }
}