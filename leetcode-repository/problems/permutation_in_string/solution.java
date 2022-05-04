class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] table=new int[26];
        int m=s1.length();
        int n= s2.length();
        
        if(m>n){
          return false;   
        }
        
        for(int i=0;i<m;i++){
            table[s1.charAt(i)-'a']++;
            table[s2.charAt(i)-'a']--;
        }
       
        if(zeroCount(table))
            return true;
            
        for(int i=m;i<n;i++){
            table[s2.charAt(i)-'a']--;
            table[s2.charAt(i-m)-'a']++;
            if(zeroCount(table))
                return true;
        }
        return false;
    }
    
    
    public boolean zeroCount(int[] t){
        for(int i=0;i<t.length;i++){
           if(t[i]!=0)
               return false;
        }
        return true;
    }
}