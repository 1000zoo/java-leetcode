//https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/submissions/857867462/
//2022-12-11

package array;

public class FinalPricesWithSpecialDiscount {

    //Complexity
    //Time : O(N ^ 2)
    //Space: O(N) for return
    //where N is length of prices
    //Runtime 1 ms 99.69%
    //Memory 42.3 MB 94.26%
    public int[] finalPrices(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int min = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    min = prices[j];
                    break;
                }
            }
            answer[i] = prices[i] - min;
        }

        return answer;
    }
}
