class Solution {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ss.length;i++){
            sb.append(reverse(ss[i])).append(" ");
        }
        return new String(sb).trim();                
    }
                      
    public String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }                  
}