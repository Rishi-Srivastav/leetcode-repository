class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n=nums.length;
        int[] visited=new int[n];
        int sum= Arrays.stream(nums).sum();
        if(sum%k!=0) return false;
        int target = sum/k;
        
        return !Arrays.stream(nums).filter(num->num>target).findAny().isPresent() && check(nums, visited, k, 0, target, 0);
        
    }
    
    public boolean check(int[] nums, int[] visited, int k, int sum, int target, int start){
        if(k==1) return true;
        
        if(sum==target)
            return check(nums, visited, k-1, 0, target, 0);
        
        if(sum>target) return false;
        
        for(int i=start;i<nums.length;i++){
            if(visited[i]==0){
                visited[i]=1;
                if(check(nums, visited, k, sum+nums[i], target, i+1)) return true;
                visited[i]=0;
            }
        }
        return false;
    }
}