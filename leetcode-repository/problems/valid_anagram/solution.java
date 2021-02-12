class Solution {
    public boolean isAnagram(String s, String t) {
        char[] x = new char[256];
       
        for(char c: s.toCharArray()){
            x[c]++;
        }
        
         for(char c: t.toCharArray()){
            x[c]--;
        }
        
         for(int i:x){
           if(i!=0){
               return false;
           }
        }
        return true;
    }
}