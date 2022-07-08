class Solution {
    public int removeDuplicates(int[] nums) {
        int index=1;
        int shifts=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                shifts++;
                continue;
            }
            int tmp=nums[i];
            nums[index]=tmp;
            index++;
        }
        return nums.length-shifts;
}
}