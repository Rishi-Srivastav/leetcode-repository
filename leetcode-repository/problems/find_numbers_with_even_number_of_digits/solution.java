class Solution {
    public int findNumbers(int[] nums) {
        int n=0;
        for(int i=0;i<nums.length;i++){
            if(findLength(nums[i])){
                n++;
            }
        }
        return n;
    }
    
    private static boolean findLength(int n){
        int l=0;
        while(n!=0){
            n=n/10;
            l++;
        }
        return l%2==0 ? true : false;
    }
}