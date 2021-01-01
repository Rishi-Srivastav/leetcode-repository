class Solution {
       public static boolean canFormArray(int[] arr, int[][] pieces) {
        int m = pieces.length;
        int pi = -1;
        for (int i = 0; i < m; i++) {
            int n = pieces[i].length;
            int last = -1;
            outer:
            for (int j = 0; j < n; j++) {
                boolean f = false;
                for (int k = 0; k < arr.length; k++) {
                    if (arr[k] == pieces[i][j]) {
                        f=true;
                        if (last != -1 && last != k - 1) {
                            return false;
                        }
                        last = k;
                        if (!(j < n))
                            break outer;
                        break;
                    }
                }
                if(!f)
                    return false;
            }
        }
        return true;
    }
}