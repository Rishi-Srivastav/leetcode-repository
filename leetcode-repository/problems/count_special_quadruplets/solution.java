class Solution {
    public int countQuadruplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len=nums.length;
        map.put(nums[len-1]-nums[len-2], 1);
        int count=0;
        for(int b=len-3;b>=1;b--){
            for(int a=b-1;a>=0;a--){
                count+=map.getOrDefault(nums[a]+nums[b], 0);
            }
            
            for(int x=len-1;x>b;x--){
                map.put(nums[x]-nums[b], map.getOrDefault(nums[x]-nums[b], 0)+1);
            }
        }
        
        return count;
    }
}