class Solution {
      static char[] letters = {'0', 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    
    //2101
    public static int numDecodings(String s) {
        int n = s.length();
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;

        if(!s.isEmpty() && s.charAt(0) == '0') {
            return 0;
        }

        if (s.length() == 0)
            return 0;

        for (int i = 2; i <= n; i++) {

            if(s.charAt(i-1)=='0' && s.charAt(i-2)=='0')
                return 0;

            count[i] = count[i - 1];

            if (s.charAt(i - 2) == '1' || (s.charAt(i - 1) < '7' && s.charAt(i - 2) == '2')) {
                if (s.charAt(i - 1) == '0' || s.charAt(i - 2) == '0' || (i<n && s.charAt(i)=='0'))
                    count[i] = count[i - 2];
                else
                    count[i] += count[i - 2];
            } else{
                if(s.charAt(i-1)=='0' && s.charAt(i-2)>'2')
                    return 0;
            }
        }
        return count[n];
    }     
}