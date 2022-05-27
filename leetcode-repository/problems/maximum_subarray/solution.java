class Solution {
    public int maxSubArray(int[] nums) {
        int max_so_far=nums[0], max_here=0;
        for(int i=0;i<nums.length;i++){
            if(max_here+nums[i]>0){
                max_here=max_here+nums[i];
                max_so_far = Math.max(max_so_far, max_here);
            } else{
                max_so_far = Math.max(max_so_far, max_here+nums[i]);
                max_here=0;
            }
        }
        return max_so_far;
    }
}