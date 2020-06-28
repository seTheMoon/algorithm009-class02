class Solution {
    public int minPathSum(int[][] grid) {
        
        int res[][] = new int[grid.length][grid[0].length];
        res[0][0] = grid[0][0];
        
        for (int i = 0;i < grid.length;i++) {
            for (int j = 0;j < grid[0].length;j++)  {
                if (i == 0 && j == 0) continue;
                if (i == 0) {
                    res[i][j] = grid[i][j] + res[i][j-1];
                    continue;
                }
                if (j == 0) {
                    res[i][j] = grid[i][j] + res[i-1][j];
                    continue;
                }
                res[i][j] = Math.min(res[i-1][j],res[i][j-1]) + grid[i][j];
            }
        }
        return  res[grid.length-1][grid[0].length-1];
    }
}

// DP
// a.分支寻找最优子结构  res[i][j] = min(a[i-1][j],a[i][j-1]) + a[i][j]
// b.存储状态方程 res[i][j]到达当前点 i,j 的最小值
// c.DP 方程