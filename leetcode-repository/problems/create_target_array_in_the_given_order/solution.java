class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
       int[] target = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            target[i] = -1;
        }
        
        for(int i=0;i<nums.length;i++){
            insert(target, index[i], nums[i]);
        }
        return target;
    }
    
    public static void insert(int[] target, int index, int val){
        if(target[index]==-1){
            target[index]=val;
        } else{
            for(int i=target.length-1;i>index;i--){
                target[i]=target[i-1];
            }
            target[index] = val;
        }
    }
}