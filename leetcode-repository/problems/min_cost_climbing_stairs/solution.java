class Solution {
    int[] price = new int[1000];
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length -1;
        
       return Math.min(calcPrice(n, cost), calcPrice(n-1, cost));
    }
    
    public int calcPrice(int n, int[] cost){
        if(n==0 || n==1)
            return cost[n];
    
        if(price[n]!=0)
            return price[n];
        
        return price[n]= cost[n] + Math.min(calcPrice(n-1, cost), calcPrice(n-2, cost));
    }
}