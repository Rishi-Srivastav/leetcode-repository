class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int counter = 0;
        int end=0, d=0;
        // checking till n-2 th element
        for(int i=0;i<n-1;i++){
           d=Math.max(d, i+nums[i]);
            if(i==end){
                end=d;
                counter++;
            }
            }
        return counter;
    }
}