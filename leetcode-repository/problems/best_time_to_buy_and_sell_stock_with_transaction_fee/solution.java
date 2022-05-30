// Two stages - Buy, SELL at any i th index. Both arrays assumes total profit, when on ith day... buy or sell happened

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n= prices.length;
        int[] buy=new int[n];
        int[] sell=new int[n];
        if(n==1) return 0;
        buy[0]=-prices[0]-fee;
        sell[0]=0;
        
        for(int i=1;i<n;i++){
            // Add transaction fee only once while buying.
            buy[i]=Math.max(sell[i-1]-prices[i]-fee, buy[i-1]);
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
        }
        return sell[n-1];
    }
}