class Solution {
    public boolean checkValid(int[][] matrix) {
    	int m = matrix.length;
		for (int i = 0; i < m; i++) {
			boolean[] rows = new boolean[m];
			boolean[] cols = new boolean[m];
			for (int j = 0; j < m; j++) {
				if(rows[matrix[i][j]-1]) return false;
				else rows[matrix[i][j]-1]=true;
				
				if(cols[matrix[j][i]-1]) return false;
				else cols[matrix[j][i]-1]=true;
			}
		}
		return true;
    }
}