class Solution {
    public int reachNumber(int target) {
        int sum = 0;
        int n= 0;
        if(target<0){
            target = -1*target;
        }
        
        for(int i=1;i<Integer.MAX_VALUE;i++){
           sum+=i; 
            if(sum>=target){
                n = i;
                break;
        }
        }
        int diff = sum-target;
        if(diff == 0)
            return n;
        if(diff%2==0){
            if(diff/2<=n)
                return n;
           else{
               return -1;
           }
        } else{
            while(diff%2!=0){
               n++;
               diff = diff +n;
            }
            
            return n;
        }
    }
}