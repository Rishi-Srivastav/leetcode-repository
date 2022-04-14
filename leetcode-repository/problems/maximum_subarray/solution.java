class Solution {
    public int maxSubArray(int[] nums) {
        int max_so_far=Integer.MIN_VALUE, max_here=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
           max_here=Math.max(max_here+nums[i], nums[i]);
              if(max_so_far<max_here){
                max_so_far=max_here;
            }
        }
        return max_so_far;
    }
}