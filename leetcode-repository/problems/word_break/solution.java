class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);  
        return check(s, set);
    }
    
    public boolean check(String s, Set<String> set){
        int len = s.length();
        boolean[] f=new boolean[len+1];
        f[0]=true;
        
        for(int i=1;i<=len;i++){
            for(int j=0;j<i;j++){
                if(f[j] && set.contains(s.substring(j,i))){
                    f[i]=true;
                    break;
                }
            }
        }
        return f[len];
    }
    
    
    // Brute Force - Recursive Solution
/**    public boolean check(String s, Set<String> set){
        int len = s.length();
        if (len == 0) {
            return true;
        }
        for(int i=1;i<=s.length();i++){
            if(set.contains(s.substring(0, i)) && check(s.substring(i), set)){
                 return true;
            }
        }
        return false;
    }
    
    **/
}