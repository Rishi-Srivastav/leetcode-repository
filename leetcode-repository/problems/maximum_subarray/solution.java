class Solution {
     public int maxSubArray(int[] nums) {
        int sumyet = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i< nums.length;i++) {
            sum = Math.max(sum+nums[i], nums[i]);
            if (sumyet < sum) {
                sumyet = sum;
            }
        }
            return sumyet;
        }
}