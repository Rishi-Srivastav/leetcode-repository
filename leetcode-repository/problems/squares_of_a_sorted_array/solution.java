class Solution {
    public int[] sortedSquares(int[] nums) {
        int i=0, j=nums.length-1;
        int[] res= new int[nums.length];
        for(int p=nums.length-1;p>=0;p--){
            if(sq(nums[i])>=sq(nums[j])){
                res[p]=sq(nums[i]);
                i++;
            } else {
                res[p]=sq(nums[j]);
                j--;
            }
        }
        return res;
    }
    
    public int sq(int n){
        return n*n;
    }
}

