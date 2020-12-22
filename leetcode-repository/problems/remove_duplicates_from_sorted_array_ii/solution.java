class Solution {
    public int removeDuplicates(int[] nums) {
        int l = nums.length;
        int ans = l;
        if(l==0 || l==1 || l==2)
            return l;
        
        int num=nums[0];
        int count = 1;
        
        for(int i=1;i<ans;i++){
            if(nums[i]==num){
                count++;
                if(count>2){
                    deleteThis(nums, i);
                    i--;
                    count--;
                    ans--;
                }
            } else {
                num = nums[i];
                count = 1;
            }
        }
        return ans;
    }
    
    public static void deleteThis(int[] a, int pos){
        for(int i=pos;i<a.length-1;i++){
            a[i] = a[i+1];
        }
        a[a.length-1]= Integer.MIN_VALUE;
    }
}