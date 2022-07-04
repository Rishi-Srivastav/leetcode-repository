class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists=new ArrayList();
        permute(lists, nums, 0);
        return lists;
        
    }
    
    public void permute(List<List<Integer>> lists, int[] nums, int start){
        if(start==nums.length-1){
            List<Integer> list=new ArrayList();
            for(int k:nums) {
                list.add(k);
            }
            lists.add(list);
            return;
        }
        
        
        for(int i=start;i<nums.length;i++){
            swap(nums, i, start);
            permute(lists, nums, start+1);
            swap(nums,start,i);
        }
    }
    
    public int[] swap(int[] arr , int i, int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
        return arr;
    }
    

    
}