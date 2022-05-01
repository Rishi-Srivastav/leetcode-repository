class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i <= n; i++) {
            String pattern = s.substring(0, i);
            for (int j = i; j <= n-i; j=j+i) {
                String nxt = s.substring(j, j + i );
                if (pattern.equalsIgnoreCase(nxt)) {
                    if (j + i >= n) {
                        return true;
                    }
                    continue;
                } else {
                    break;
                }
            }
        }
        return false;
    }
}