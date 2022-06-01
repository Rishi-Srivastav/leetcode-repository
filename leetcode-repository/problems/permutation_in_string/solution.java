class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1=s1.length();
        int l2=s2.length();
        char[] az=new char[26];
        for(int i=0;i<l1;i++){
            az[s1.charAt(i)-'a']++;
        }
       int start=0, end=0;
        for(int i=0;i<=l2-l1;i++){
            start=i;
            end=i+l1-1;
            if(checkAllPresent(s2,start,end,Arrays.copyOf(az, 26))){
                return true;
            }
      }
        return false;
    }
    
    public boolean checkAllPresent(String s, int start, int end, char[] c){
        for(int i=start;i<=end;i++){
            if(c[s.charAt(i)-'a']<=0){
                return false;
            }
            c[s.charAt(i)-'a']--;
        }
        
        for(int i=0;i<c.length;i++){
            if(c[i]!=0){
                return false;
            }
        }
        return true;
    }
}