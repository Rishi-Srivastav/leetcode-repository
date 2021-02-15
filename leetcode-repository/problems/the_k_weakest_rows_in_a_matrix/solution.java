class Solution {
     public static int[] kWeakestRows(int[][] mat, int k) {
        int r = mat.length;
        int c = mat[0].length;


        int[][] result = new int[c+1][r+1];

        for(int i=0;i<c+1;i++){
            for(int j=0;j<r+1;j++){
                result[i][j] = -1;
            }
        }
        int size[] = new int[c+1];
        int max = -1;

        for(int i=0;i<r;i++){
            int count = 0;
            for(int j=0;j<c;j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            result[count][size[count]] = i;
            size[count] ++;
            if(max<size[count]){
                max = size[count];
            }
        }

        int n = 0;
        int res[] = new int[k];

        outer:
        for(int i=0;i<c+1;i++){
            for (int j=0;j<r+1;j++){
                if(n==k){
                    break outer;
                }
                if(result[i][j]!=-1){
                    res[n] = result[i][j];
                    n++;
                }
            }
        }
        return res;
    }
}