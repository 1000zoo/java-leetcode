//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//2022-01-04
//retry 2022-10-19

package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStock {

    //solution1
    //가장 쉽게 생각할수 있는 O(N^2)
    //Time Limit Exceeded
    public int solution1(int[] prices) {
        int max = Integer.MIN_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                profit = prices[j] - prices[i];
                max = Math.max(profit, max);
            }
        }
        return Math.max(max, 0);
    }

    //refer: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/1735550/Python-Javascript-Easy-solution-with-very-clear-Explanation
    //solution2
    //매수 시점 보다 매도 시점의 값이 클 때만 매수시점을 변경해줌
    //Runtime: 3 ms, faster than 76.30% of Java online submissions for Best Time to Buy and Sell Stock.
    //Memory Usage: 83.4 MB, less than 57.32% of Java online submissions for Best Time to Buy and Sell Stock.
    public int solution2(int[] prices) {
        int buyTime = 0;
        int sellTime = 1;
        int profit = 0;
        int max = Integer.MIN_VALUE;

        for (; sellTime < prices.length; sellTime++) {
            profit = prices[sellTime] - prices[buyTime];
            max = Math.max(profit, max);
            if (profit < 0) {
                buyTime = sellTime;
            }
        }
        return Math.max(max, 0);
    }
}