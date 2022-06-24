class Solution {
    public int majorityElement(int[] nums) {
        int n=nums[0], count=1;
        for(int i=1;i<nums.length;i++){
            if(count==0){
                count++;
                n=nums[i];
            }
            else if(n==nums[i])    count++;
            else count--;   
    }
    return n;
    }
}