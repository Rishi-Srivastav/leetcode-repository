class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        if (target < matrix[0][0])
            return false;
        int row = 0;
        for (int i = 0; i < r - 1; i++) {
            if (matrix[i][0] <= target && matrix[i + 1][0] > target) {
                row = i;
                break;
            }
            if (i == r - 2) {
                row = r - 1;
            }
        }
        for (int j = 0; j < c; j++) {
            if (matrix[row][j] == target)
                return true;
        }
        return false;
    }
}