class Solution {
    
    int[] steps = new int[46];
    public int climbStairs(int n) {
        if(n==0 || n==1){
            return 1;
        }
        if(steps[n]!=0){
            return steps[n];
        }
        
        return steps[n]= climbStairs(n-1) + climbStairs(n-2);
    }
}