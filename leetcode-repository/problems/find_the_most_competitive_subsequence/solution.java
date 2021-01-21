class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int r = k-n;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<n;i++){
            
           if(stack.isEmpty()){
              stack.push(nums[i]);
              continue;
           }
            int rem = n-i-1;
            
            while(!stack.isEmpty() && stack.peek()>nums[i]){
               if(stack.size() + rem >= k){
                     stack.pop(); 
                }  else
                    break;
              }
            stack.push(nums[i]);
            } 
        
        int[] arr = new int[k];
        for(int i=0;i<k;i++){
            arr[i]= stack.get(i);
        }
        
        return arr;
   }
        
}