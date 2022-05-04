class Solution {
    /**
    0,2 0,3  2,
    
    **/
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map=new HashMap<>();
        int n=s.length()-1;
        int max=0, start=0, end=0;
        if(n==-1 || n==0)
            return n+1;
        for(int i=0;i<=n;i++){
            char ch= s.charAt(i);
            if(map.containsKey(ch)){
                start=Math.max(start, map.get(ch)+1); 
               // System.out.println("start="+start+", end="+end+", max="+max);    
            }
            max=Math.max(max, i-start+1);
            map.put(ch,i);
        }
        return max;
    }
}