//2023-11-24
//https://leetcode.com/problems/unique-paths-ii/

package dynamic_programming;

import java.util.*;

public class UniquePaths2 {

    //Runtime: 1ms Beats 23.11%
    public int uniquePathsWithObstacles(int[][] grid) {
        if (grid[0][0] == 1) return 0;
        int[][] dp = new int[grid.length][grid[0].length];

        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        for (int i = 0; i < dp.length; i++) {
            if (grid[i][0] == 1) break;
            dp[i][0] = 1;
        }

        for (int i = 0; i < dp[0].length; i++) {
            if (grid[0][i] == 1) break;
            dp[0][i] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (grid[i][j] == 1) continue;
                if (dp[i][j - 1] == Integer.MAX_VALUE || dp[i - 1][j] == Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        if (dp[dp.length - 1][dp[0].length - 1] == Integer.MAX_VALUE) return 0;

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
