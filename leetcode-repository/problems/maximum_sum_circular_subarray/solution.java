class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxAll=nums[0], minAll=nums[0], maxthis=0, minthis=0, totalSum=0;
        for(int i=0;i<nums.length;i++){
            maxthis=Math.max(nums[i],maxthis+nums[i]);
            maxAll=Math.max(maxthis,maxAll);
            minthis=Math.min(nums[i],minthis+nums[i]);
            minAll=Math.min(minAll, minthis);
            totalSum+=nums[i];
        }
        return maxAll>0 ? Math.max(maxAll, totalSum-minAll): maxAll;
    }
}