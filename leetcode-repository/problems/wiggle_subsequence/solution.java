class Solution {
    
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length; 
        if (n <= 1) return n; 
        
        int up = 1, down = 1; 
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) up = down + 1; 
            if (nums[i] < nums[i - 1]) down = up + 1; 
        }   
        return Math.max(up, down); 
    }
}