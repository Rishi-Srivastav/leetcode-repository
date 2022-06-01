class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> set=new HashMap();
        char[] arr=s.toCharArray();
        if(arr.length==0)
            return 0;
        set.put(arr[0],0);
        int start=0;
        int max=1;
        for(int i=1;i<arr.length;i++){
            if(set.containsKey(arr[i])){
                max=Math.max(max, i-start);
                start=Math.max(set.get(arr[i])+1, start);
               // System.out.println("arr="+arr[i]+ ", i="+i+", start="+start+", max= "+max);
               } 
             set.put(arr[i],i);
        }
        return Math.max(max, arr.length-start);
    }
}