class Solution {
    public void reverseString(char[] s) {
        reverse(s,0,s.length-1);
    }
    
    public void reverse(char[] s, int l, int r){
        if(l>=r)
            return;
        char tmp = s[l];
        s[l]=s[r];
        s[r]=tmp;
        //System.out.println("sdcdd -- "+s);
        reverse(s,l+1,r-1);
    }
}