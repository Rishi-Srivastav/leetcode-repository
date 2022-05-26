class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int[] max=new int[100];
        initializeMax(max);
        int a= maxi(Arrays.copyOfRange(nums,0, n-1), n-2, max);
        initializeMax(max);
        int b=maxi(Arrays.copyOfRange(nums,1, n), n-2, max); 
        return Math.max(a,b);
    }
    
    public int maxi(int[] nums, int n, int[] max){ 
        if(n==0 || n==1){
            max[0]=nums[0];
            max[1]= nums.length<=1 ? -1 : Math.max(nums[0], nums[1]);
            return max[n];
        }
        
        if(max[n]!=-1){
            return max[n];
        }
        return max[n]=Math.max(maxi(nums,n-2,max) + nums[n], maxi(nums, n-1,max));
        }   
    
    
    public void initializeMax(int[] max){
        for(int i=0;i<100;i++)
            max[i]=-1;
    }
}