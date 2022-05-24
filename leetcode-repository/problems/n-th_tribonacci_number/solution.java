class Solution {
    int[] ts= new int[38];
    public int tribonacci(int n) {
        if(n==0 || n==1 || n==2){
            return n==0?0:1;
        }
        
        if(ts[n]!=0){
            return ts[n];
        }
        
        return ts[n] = tribonacci(n-2) + tribonacci(n-1) + tribonacci(n-3);
    }
}