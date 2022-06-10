class Solution {
    public String longestPalindrome(String s) {
        char[] c=s.toCharArray();
        int start=0, end=0, max=1;
        for(int i=1;i<c.length;i++){
            //even check
            int a=i-1, b=i;
            while(a>=0 && b<c.length && c[a]==c[b]){
                a--;
                b++;
            }
            if(b-a+1>max){
                start=a+1;
                end=b-1;
                max=b-a+1;
            }
            System.out.println("max="+max+ ", start="+start+", end="+end);
            a=i-1;
            b=i+1;
            //odd check
            while(a>=0 && b<c.length && c[a]==c[b]){
                a--;
                b++;
            }
            if(b-a+1>max){
                start=a+1;
                end=b-1;
                max=b-a+1;
            }
            System.out.println("max="+max+ ", start="+start+", end="+end);
        }
        
        return s.substring(start,end+1);
    }
}