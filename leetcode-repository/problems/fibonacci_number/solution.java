class Solution {
    
    int[] fs = new int[31];
   
    public int fib(int n) {
      if(n==0 || n==1)
          return n;
        if(fs[n]!=0){
            return fs[n];
        }
        return fs[n] = fib(n-1)+fib(n-2);
    }
}