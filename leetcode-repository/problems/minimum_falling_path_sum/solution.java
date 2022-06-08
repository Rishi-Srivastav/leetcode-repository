class Solution {
  public int minFallingPathSum(int[][] A) {
    for (int i = 1; i < A.length; ++i)
        for (int j = 0; j < A.length; ++j)
          A[i][j]+=Math.min(A[i-1][j], Math.min(A[i-1][Math.max(0,j-1)], A[i-1][Math.min(A.length-1,j+1)]));
      return Arrays.stream(A[A.length-1]).min().getAsInt();
    }  
}



/** My Recursive Solution
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int sum=0, min=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            sum=falldown(matrix, 0, j, 0);
            min=Math.min(sum, min);
        }
        return min;
    }
    
    public int falldown(int[][] matrix, int i, int j, int sum){
        if(i==matrix.length){
            return sum;
        }
        
        int s1=Integer.MAX_VALUE,s2=Integer.MAX_VALUE,s3=Integer.MAX_VALUE;
        
        s1=falldown(matrix, i+1, j, sum+matrix[i][j]);
        
        if(j<matrix.length-1){
            s2=falldown(matrix, i+1, j+1, sum+matrix[i][j]);
        }
        if(j>0){
            s3=falldown(matrix, i+1, j-1, sum+matrix[i][j]);
        }
        return Math.min(s1, Math.min(s2,s3));
    }
}

**/