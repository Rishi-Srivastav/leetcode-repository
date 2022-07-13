class Solution {
    public int[] productExceptSelf(int[] nums) {
        Set<Integer> zeros=new HashSet<>();
        int prod = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0)
                zeros.add(i);
            else{
                prod*=nums[i];
            }
        }
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(zeros.size()>1){
                break;
            } else {
                if(nums[i]==0){
                    ans[i]=prod;
                } else if ( nums[i]!=0 && zeros.size()==1) {
                    ans[i]=0;
                } else {
                    ans[i] = prod/nums[i];
                }
            }
        }
        return ans;
    }
}