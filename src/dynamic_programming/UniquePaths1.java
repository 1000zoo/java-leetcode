//2023-11-23
//https://leetcode.com/problems/unique-paths/

package dynamic_programming;

import java.util.*;

public class UniquePaths1 {

    //Runtime: 1ms Beats 9.59%
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (dp[i][j - 1] == Integer.MAX_VALUE || dp[i - 1][j] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}
