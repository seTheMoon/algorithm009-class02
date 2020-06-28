class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        char[] c = s.toCharArray();
        boolean[][] dp = new boolean[c.length][c.length];

        for (int i = c.length-1;i >= 0; i--) {
            for (int j = i; j <= c.length-1; j++) {
                if (c[i] == c[j] && (j - i <= 2 || dp[i+1][j-1] == true)) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }

        return res;
    }
}

//  DP  
//  a.分支求最优解  dp[i][j] = c[i] == c[j] ? dp[i+1][j-1] : false
//  b.存储状态数组  dp[i][j]
//  c.DP 方程