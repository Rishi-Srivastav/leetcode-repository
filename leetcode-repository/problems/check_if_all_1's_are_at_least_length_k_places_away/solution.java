class Solution {
    public boolean kLengthApart(int[] nums, int k) {
       int n = nums.length, last = -1;
        for(int i=0;i<n;i++){
            if(last==-1 && nums[i]==1){
                last=i;
                continue;
            }
            else if(nums[i]==1){
                if(i-last-1>=k){
                    last=i;
                    continue;
                } else return false;     
        } 
    }
        return true;
    }
}