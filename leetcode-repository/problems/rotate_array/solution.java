class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k=k%n;
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
    }
    
    public void reverse(int[] num, int l, int r){
     while(l<=r){
            int tmp = num[l];
            num[l]=num[r];
            num[r]=tmp;
         l++;
         r--;
        }
    }
}