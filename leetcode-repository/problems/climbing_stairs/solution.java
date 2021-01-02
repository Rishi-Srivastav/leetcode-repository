class Solution {
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        
        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        return calculate(n, 1, f);
    }
    
    //f[n] = f[n-1]+f[n-2];
    public static int calculate(int n, int sum, int[] f){
        
        if(sum == n){
            return f[sum];
        }
        sum++;
        f[sum] = f[sum-1] + f[sum-2]; 
        return calculate(n, sum, f);
    }
}