class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> map = new HashSet();
        Set<List<Integer>> lists= new HashSet();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int a = nums[i];
            for(int j=0;j!=i && j<nums.length;j++){
                int b=nums[j];
                if(map.contains(-(a+b))){
                    lists.add(Arrays.asList(a,b,-(a+b)));
                }
                map.add(b);
            }
            map.clear();
        }
        return new ArrayList(lists);
    }
}