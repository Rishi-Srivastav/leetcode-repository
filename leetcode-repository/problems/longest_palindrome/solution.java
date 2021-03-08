class Solution {
    public int longestPalindrome(String s) {
        int[] ctab = new int[128]; 
        for(char c: s.toCharArray()){
            ctab[c] ++;
        }
        boolean odd = false;
        int count=0;
        for(int k: ctab){
            if(k%2==0){
                count+=k;
            } else {
                if(!odd){
                    count+=k;
                    odd=true;
                } else {
                    count+=k-1;
                }
            }
        }
        return count;
    }
}