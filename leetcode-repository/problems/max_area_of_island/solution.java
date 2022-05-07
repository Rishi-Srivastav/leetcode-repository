class Solution {
    public int maxAreaOfIsland(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int max=0;  
      for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
              int visit[][]=new int[m][n];
              if(grid[i][j]==1){
                  max = Math.max(max, calculateMax(i, j, grid, 0, visit));
              }
          }
      }  
        return max;
    }
    
    public int calculateMax(int r, int c, int[][] grid, int max, int[][] visit){
        if( r<0 || c<0 || r==grid.length || c==grid[0].length || grid[r][c]==0 
           || visit[r][c]==1) {
            return 0;
        }

        visit[r][c]=1;
        return 1
            +calculateMax(r-1,c,grid,max, visit)
            + calculateMax(r,c-1,grid,max, visit)
            + calculateMax(r+1,c,grid,max, visit)
            + calculateMax(r,c+1,grid,max, visit);
    }
}