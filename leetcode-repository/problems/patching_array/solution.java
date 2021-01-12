class Solution {
    // nums = [1, 3]
    // n=6
    public int minPatches(int[] nums, int n) {
        int l = nums.length;
        int ans=0, max=0, j=0, m=0, mod=1000000000 ;
        for(int i=0;i<n;i++){
            if(j<l && nums[j]<=max+1){
                max += nums[j];
                j++;
            } else {
                if(max>=1073741824){
                     ans++; 
                     break;
                }
                max = 2*max+1;
                ans++;  
            }
            if(max>=n)
                break;
        }
        return ans;
    }
}