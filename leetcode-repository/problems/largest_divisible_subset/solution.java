/**
If the largest number in subset formed till now divides the next element to be chosen, then every other element in the subset will divide it as well (because subset formed till now follows above conditions). For eg. Consider our subset till now is [1,2,6] and next element is 12. If 12 divides largest element of subset - 6, it will divide every other element as well. Try for other examples yourself.

**/
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        
        Arrays.sort(nums);
        int[] dp = new int[n];
        int max_i=0, index=-1;
        int[] prev=new int[n];
        int[] count = new int[n];
        
        for(int i=n-1;i>=0;i--){
            dp[i]=1;
            prev[i]=-1;
            for(int j=i+1;j<n;j++){
                if(nums[j]%nums[i]==0 && dp[i]<dp[j]+1){
                   dp[i]=dp[j]+1;
                    prev[i]=j;
                }
            }
            
             if (dp[i] > max_i) {
                max_i = dp[i];
                index = i;
            }
           
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = prev[index];
        }
        return res;
    }
}