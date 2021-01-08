class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int l1 = word1.length;
        int l2 = word2.length;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<l2;i++){
            sb.append(word2[i]);
        }
        String s2 = new String(sb);
        
        StringBuilder sb1 = new StringBuilder();
        for(int i=0;i<l1;i++){
            sb1.append(word1[i]);
        }
        String s1 = new String(sb1);
        
        return s1.equals(s2);
    }
}