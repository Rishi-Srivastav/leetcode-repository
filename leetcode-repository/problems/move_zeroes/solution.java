class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int first=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==0 && first==-1){
                first=i;
            } else {
                if(nums[i]!=0 && first!=-1){
                    nums[first] = shiftRight(nums, first, i);
                first++;
                }
            }
            
        }
    }
    
    public int shiftRight(int[] nums, int i, int j){
        int tmp=nums[j];
        for(int k=j;k>i;k--){
            nums[k]=nums[k-1];
        }
        return tmp;
    }
}