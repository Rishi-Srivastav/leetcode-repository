class Solution {
    public String addBinary(String a, String b) {
         if(a == null || a.isEmpty()) {
            return b;
        }
        if(b == null || b.isEmpty()) {
            return a;
        }
        
        int m=a.length()-1;
        int n=b.length()-1;
        char[] ac=a.toCharArray();
        char[] bc=b.toCharArray();
        StringBuilder sb=new StringBuilder();
        int abit=0, bbit=0, c=0;
        
        while(m>-1 || n>-1 || c==1){
            abit= m>-1? Character.getNumericValue(ac[m--]):0; 
            bbit= n>-1? Character.getNumericValue(bc[n--]):0;
            int res = abit^bbit^c;
            sb.append(res);
            c=(abit+bbit+c >= 2)?1:0;
        }
        
        return sb.reverse().toString();
    }
}