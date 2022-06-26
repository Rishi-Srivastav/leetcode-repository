class Solution {
    public void sortColors(int[] nums) {
        int red=0, white=0, blue=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) red++;
            else if(nums[i]==1) white++;
            else blue++;
        }
        int j=0;
        while(red>0){
            nums[j++]=0;
            red--;
        }
        
        while(white>0){
          nums[j++]=1;
          white--;
       }
        
        while(blue>0){
          nums[j++]=2;
          blue--;
        }
    }
}