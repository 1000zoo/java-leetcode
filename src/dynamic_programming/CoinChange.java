//2023-11-23
//https://leetcode.com/problems/coin-change/submissions/1104564574/

package dynamic_programming;

import java.util.Arrays;

public class CoinChange {

    //Runtime: 10ms Beats 99.56%
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
