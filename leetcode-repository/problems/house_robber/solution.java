class Solution {
    int[] max=new int[100];
    
    public int rob(int[] nums) {
        int n=nums.length-1;
        if(n==0){
            return nums[0];
        }
        initializeMax();
        max[0]=nums[0];
        max[1]=Math.max(nums[0], nums[1]);
        return maxi(nums, n);  
    }
    
    public int maxi(int[] nums, int n){ 
        if(n==0 || n==1){
            return max[n];
        }
        
        if(max[n]!=-1){
            return max[n];
        }
        return max[n]=Math.max(maxi(nums,n-2) + nums[n], maxi(nums, n-1));
        }   
    
    
    public void initializeMax(){
        for(int i=0;i<max.length;i++)
            max[i]=-1;
    }
}