class Solution {
    public String findLongestWord(String s, List<String> d) {
        int max = 0;
        String result="";
        Collections.sort(d);
        for(String str: d){
            int this_max = longest(s, str);
            if(this_max>max){
                max= this_max;
                result=str;
            }
        }
        return result;
    }
    
    public static int longest(String s, String str){
        int i=0,j=0,m=s.length(), n=str.length();
        int count=0;
        for(i=0; i<m && j<n;i++){
            if(s.charAt(i)==str.charAt(j)){
                count++;
                j++;
            }
        }
        return j==n?count:0;
    }
}