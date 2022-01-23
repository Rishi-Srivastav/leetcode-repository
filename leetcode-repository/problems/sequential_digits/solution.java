class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
          if (low >= 10 && high <= 1000000000) {
            List<Integer> list = new ArrayList<>();
            char l[] = Integer.toString(low).toCharArray();
            char h[] = Integer.toString(high).toCharArray();
            int n = l.length;
            int i = Character.getNumericValue(l[0]);
            while (n <= h.length) {
                addAllInRange(list, n, l, h, i);
                n++;
                i=1;
            }
            return list;
        }
        return null;
    }
    
        private void addAllInRange(List<Integer> list, int n, char[] low, char[] high, int i) {
        while (i + n <= 10) {
            char[] nx = new char[n];
            int k = i;
            for (int j = 0; j < n; j++) {
                nx[j] = Character.forDigit(k, 10);
                k++;
            }
            int ans = Integer.parseInt(String.copyValueOf(nx));
            if(ans <  Integer.parseInt(String.copyValueOf(low))){
                i++;
                continue;
            } 
            if(ans > Integer.parseInt(String.copyValueOf(high))){
                break;
            }
            list.add(ans);
            i++;
        }
    }

}