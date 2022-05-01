class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int[] ans=new int[2];
        for(int i=0;i<n;i++){
            ans[0]=i+1;
            int k=target-numbers[i];
            int res=binarySearch(numbers,k,i+1,n-1);
            if(res!=-1){
                ans[1]=res+1;
                break;
            }
        }
        return ans;
    }
    
    public int binarySearch(int[] nums, int k, int start, int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==k){
                return mid;
            } else if(nums[mid]>k) {
                end=mid-1;
            } else {
                start=mid+1;
            }
        }
        return -1;
    }
}