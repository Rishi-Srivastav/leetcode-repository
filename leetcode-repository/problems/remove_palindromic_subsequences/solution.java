class Solution {
    public int removePalindromeSub(String s) {
        char[] c = s.toCharArray();
        if(c.length==0)
            return 0;
        boolean b = true;
        for(int i=0;i<c.length/2;i++){
            if(c[i]!=c[c.length-i-1]){
                b=false;
                break;
            }
        }
        
        return b?1:2;        
    }
}