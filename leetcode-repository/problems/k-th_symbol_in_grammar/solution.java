class Solution {
    public int kthGrammar(int N, int K) {
        int c = back(N, K);
        System.out.println(c);
        
        return c;
    }
    
    public static int back(int n, int k){
        if(n==1){
            return 0;
        }
      if(k%2==0){
          return back(n-1, k/2) ==0 ? 1:0;
      } else {
          return back(n-1, (k+1)/2);
      }
    }
}