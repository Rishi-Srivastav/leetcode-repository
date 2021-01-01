class Solution {
    public void reverseString(char[] s) {
        int low =0, high = s.length-1;
        
        helper(s, low, high);
    }
    
  
    public void helper(char[] s, int low, int high){
        if(low>=high)
            return;
        
        char t = s[low];
        s[low++] = s[high];
        s[high--]= t;
        helper(s, low, high);
    }
}