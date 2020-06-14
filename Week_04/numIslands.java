class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid.length == 0) return res;
        int m = grid.length;
        int n = grid[0].length;
        for  (int i = 0;i < m; i++) {
            for (int j = 0; j < n;j++) {
                if (grid[i][j] == '1') {
                    res++;
                    recursiveHelper(grid,m,n,i,j);
                }
            }
        }
        return res;
    }

    public void recursiveHelper(char[][] grid,int m,int n,int i,int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
            return;
        } 

        grid[i][j] = '0';
        recursiveHelper(grid,m,n,i-1,j);
        recursiveHelper(grid,m,n,i+1,j);
        recursiveHelper(grid,m,n,i,j-1);
        recursiveHelper(grid,m,n,i,j+1);
    }
}