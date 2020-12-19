class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, this_max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                this_max++;
            } 
            
             if(max<this_max){
                  max=this_max;
             }
            if(nums[i]==0)
                this_max=0;
        }
        return max;
    }
}