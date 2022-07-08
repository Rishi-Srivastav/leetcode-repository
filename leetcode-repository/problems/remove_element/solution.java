class Solution {
    public int removeElement(int[] nums, int val) {
        int index=0;
        int shifts=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                shifts++;
                continue;
            }
            nums[index]=nums[i];
            index++;
         }
        return nums.length-shifts;
    }
}