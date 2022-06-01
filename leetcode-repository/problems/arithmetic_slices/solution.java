class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        if(n<3)
            return 0;
        int d=nums[1]-nums[0];
        int count=1, sum=0;
        for(int i=0;i<n-1;i++){
            if(nums[i+1]==nums[i]+d){
                count++;
            } else {
                sum+=count(count);
                count=2;
                d=nums[i+1]-nums[i];
            }
            }
        sum=sum+count(count);
        return sum;
    }
    
    public int count(int n){
      int sum=0;
      if(n<3) return 0; 
      if(n==3) return 1;
      
        return (n-1)*(n-2)/2;
}
}