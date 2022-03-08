class Solution {
       public int maxProfit(int[] prices) {
        int minbuy=prices[0], maxp=0;
        for(int i=1;i< prices.length;i++){
            maxp= Math.max(maxp, prices[i]-minbuy);
           minbuy = Math.min(minbuy,prices[i]);
            }
        return maxp;
    }
}