class Solution {
 	public boolean isValidSudoku(char[][] board) {
		int m = board.length;
		int n = board.length;

		for (int i = 0; i < m; i++) {
			boolean[] rows = new boolean[9];
			boolean[] cols = new boolean[9];
			boolean[] box = new boolean[9];

			for (int j = 0; j < n; j++) {

				// row check
				if (board[i][j] == '.') {}
				else if (rows[board[i][j] - '1']) {
					return false;
				} else {
					rows[board[i][j] - '1']=true;
				}
				
				// col check
				if (board[j][i] == '.') {}
				else if (cols[board[j][i] - '1']) {
					return false;
				} else {
					cols[board[j][i] - '1'] =true;
				}
				
				// box check
			     int p = i/3*3 + j/3;
			     int q = i%3*3 + j%3;
				if (board[p][q] == '.') {
					continue;
				} else if (box[board[p][q] - '1']) {
					return false;
				} else {
					box[board[p][q] - '1']=true;
				}	
			}
		}

		for (int j = 0; j < n; j++) {
			char[] c19 = new char[9];
			for (int i = 0; i < m; i++) {
				if (board[i][j] == '.') {
					continue;
				}
				if (c19[board[i][j] - '0' - 1] == 0) {
					c19[board[i][j] - '0' - 1]++;
				} else {
					return false;
				}
			}
		}
		return true;
	}
}