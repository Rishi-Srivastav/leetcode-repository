class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] steps=new int[n];
        steps[0]=nums[0];
        if(n==1)
            return true;
        if(steps[0]==0)
            return false;
        
        // checking till n-2 th element
        for(int i=1;i<n-1;i++){
            steps[i]=Math.max(nums[i], steps[i-1]-1);
            if(steps[i]<=0){
                return false;
            }
        }
        
        //checking if n-1>=1 to reach end
        if(steps[n-2]>=1) return true;
        return false;
        
    }
}