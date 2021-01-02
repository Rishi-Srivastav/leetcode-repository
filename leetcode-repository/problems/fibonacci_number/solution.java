class Solution {
    public int fib(int n) {
        
        if(n==0 || n==1)
            return n;
        
        int[] f = new int[31];
        f[0]= 0;
        f[1] = 1;
        return calculateFib(n, 1, f);
    }
    
    public static int calculateFib(int n, int start, int[] f){
        if(n==start){
            return f[n];
        } else {
            start++;
            f[start] = f[start-1]+f[start-2];
            return calculateFib(n, start, f);
        }
    }
}