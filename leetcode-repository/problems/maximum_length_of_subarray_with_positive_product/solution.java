class Solution {
    public int getMaxLen(int[] nums) {
        int n=nums.length;
        
        int max=0, pos=0, neg=0;
        
        for(int i=0;i<n;i++){
            
         if(nums[i]==0){
            max=Math.max(max, pos);
             pos=0;
             neg=0;
         }
         else if(nums[i]<0) {
             max=Math.max(max,pos);
             int tmp = pos;
             pos=neg==0?0:neg+1;
             neg=tmp+1;
         } else {
             pos++;
             neg= neg==0?0:neg+1;
         }
        }
            return Math.max(pos, max);
        }
    }

