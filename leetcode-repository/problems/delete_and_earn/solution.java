class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] bucket=new int[10001];
        for(int i=0;i<nums.length;i++){
            bucket[nums[i]]+=nums[i];
        }
        
        int[] dp = new int[10001];
        dp[0]=bucket[0];
        dp[1]=Math.max(bucket[0], bucket[1]);
        for(int i=2;i<10001;i++){
            dp[i] = Math.max(bucket[i]+ dp[i-2], dp[i-1]);
        }
        return dp[10000]; 
    }
}