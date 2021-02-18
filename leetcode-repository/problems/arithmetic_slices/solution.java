class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if(n<3)
            return 0;
        
        int diff = A[1]-A[0];
        int count = 1, res = 0;
        //find biggest array
        for(int i=0;i<n-1;i++){
           if(A[i+1]-A[i] == diff){
               count++;    
           } else {
               res += getCount(count);
               count = 2;
               diff = A[i+1]-A[i];
           } 
        }
        res += getCount(count);
        return res;
    }
    
    
    public static int getCount(int n){
        if(n==3)
            return 1;
        else if(n<3)
            return 0;
        else
            return (n-2)*(n-1)/2;
    }
}