class Solution {
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        for(char i: T.toCharArray())
            count[i-'a']++;
        
        StringBuilder sb = new StringBuilder();
        for(char i: S.toCharArray()){
           while(count[i-'a']-->0)
               sb.append(i);
        }
        
        for(char c='a'; c<='z';c++){
            while(count[c-'a']-->0)
                sb.append(c);
        }   
        return new String(sb);
    }
}