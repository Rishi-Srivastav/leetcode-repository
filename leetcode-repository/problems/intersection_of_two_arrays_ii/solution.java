class Solution {
     public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>(nums1.length);
        List<Integer> list = new ArrayList<>();
        Arrays.stream(nums1).forEach(e->map.put(e, map.getOrDefault(e,0)+1));
        Arrays.stream(nums2).forEach(e-> {
            if(map.containsKey(e) && map.get(e)>0){
                map.put(e, map.get(e)-1);
                list.add(e);
            }
        });
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
        {
            res[i] = list.get(i);
        }
        return res;
    }
}