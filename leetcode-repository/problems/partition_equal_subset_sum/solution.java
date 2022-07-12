class Solution {
    public boolean canPartition(int[] nums) {
        int[] visited=new int[nums.length];
        int sum=Arrays.stream(nums).sum();
        if(sum%2!=0) return false;
        int target = sum/2;
        Arrays.sort(nums);
        return !Arrays.stream(nums).filter(n->n>target).findAny().isPresent() &&
            knapsack(nums, target);
        
        
    }
    
    public boolean knapsack(int[] nums, int target){
        boolean[][] dp = new boolean[nums.length+1][target+1];
        
        dp[0][0]=true;
        
        for (int i = 1; i <=nums.length; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <=target; j++) {
            dp[0][j] = false;
        }
        
        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=target;j++){
                dp[i][j]= dp[i-1][j];
                if(nums[i-1]<=j){
                  dp[i][j]= dp[i][j]  || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][target];
    }
}