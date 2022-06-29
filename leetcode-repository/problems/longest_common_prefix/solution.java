class Solution {
    public String longestCommonPrefix(String[] strs) {
        int l=strs.length;
        if(l==0 || strs[0].length()==0)
            return "";
        String ans = strs[0];
        for(int i=0;i<l;i++){
            while(strs[i].indexOf(ans)!=0){
                ans=ans.substring(0, ans.length()-1);
            }
        }
        return ans;
    }
}