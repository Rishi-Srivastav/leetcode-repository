class Solution {
       public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] res = new int[r][c];
        if(n*m != r*c){
            return mat;
        }

        int p=0, q=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(q<c){
                   res[p][q] = mat[i][j];
                   q++;
                } else{
                    p++;
                    q=0;
                    res[p][q] = mat[i][j];
                    q++;
                }
            }
        }
        return res;
    }
}