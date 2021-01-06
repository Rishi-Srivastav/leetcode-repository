class Solution {
    public int findKthPositive(int[] arr, int k) {
     
      int prev=0;
      int n=0, val =0;
      
      if(arr.length==0)
        return k;
        
      //  2== n=1,val=1, prev=2
      //  3== n=1,val=1, prev=3
      //  4== n=1,val=1, prev=4
      //  7== n=3,val=6, prev=7
      // 11== n=    
      for(int i=0;i<arr.length;i++){
        if(k==n)
           return val;
       
        else if(k==n+arr[i]-prev-1)
              return arr[i]-1;
          
        else if(k>n && k>n+arr[i]-prev-1) {
            n += arr[i]-prev-1; 
            prev = arr[i];
            if(arr[i]-prev-1!=0)
                val = arr[i]-1; 
            
        } else if(k>n && k<n+arr[i]-prev-1) {
            if(i==0)
                return k;
            int diff = k-n;
            int valDiff = arr[i]-prev-1;
            return val+diff+1;
        }
    }
        int diff = k-n;
        return val+diff+1;
  }
}