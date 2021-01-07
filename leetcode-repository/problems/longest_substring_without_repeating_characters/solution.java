class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        int start=0, max = 0, l=0;
        while(l<s.length()){
            if(map.containsKey(s.charAt(l))){
                start = Math.max(map.get(s.charAt(l))+1, start);
            }
            map.put(s.charAt(l), l);
            max = Math.max(max, l-start+1);
            l++;
        }
        return max;
    }
}