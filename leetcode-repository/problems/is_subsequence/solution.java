class Solution {
    public boolean isSubsequence(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(m==0)
            return true;
        if(n==0 || m>n)
            return false;
        int start=0;
        for(int i=0;start<m && i<n;i++){
            if(s.charAt(start)==t.charAt(i)){
                start++;
            }
        }
        return start==m;
    }
}