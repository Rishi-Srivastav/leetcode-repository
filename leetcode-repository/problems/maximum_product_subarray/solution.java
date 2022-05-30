class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max_all=0, max_here=0;
        if(n==1)
            return nums[0];
        
        for(int i=0;i<n;i++){
            max_here = max_here==0? nums[i] : max_here*nums[i];
            max_all=Math.max(Math.max(max_all,max_here), nums[i]);
        }
        
        max_here=0;
        
        for(int i=n-1;i>=0;i--){
            max_here = max_here==0? nums[i] : max_here*nums[i];
            max_all=Math.max(Math.max(max_all,max_here), nums[i]);
        }
        
        return max_all;
    }
}