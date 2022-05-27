class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n= numbers.length;
        int[] res=new int[2];
        
        for(int i=0;i<n;i++){
            if(map.containsKey(target-numbers[i])){
                res[0]=i+1;
                res[1]=map.get(target-numbers[i])+1;
                Arrays.sort(res);
                break;
            } else {
                map.put(numbers[i],i);
            }
        }
        return res;
    }
}