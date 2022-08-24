//2022-01-04
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStock {

    //Time Limit Exceeded
    private boolean isIncrease(int init, int fin){
        return fin > init;
    }
    public int maxProfit(int[] prices){
        if(prices.length == 1) return 0;
        boolean isLinear = true;
        boolean postState = isIncrease(prices[0], prices[1]);
        boolean initState = postState;
        int maxProfit = 0;
        List<Integer> localValue = new ArrayList<>();
        localValue.add(prices[0]);
        for(int i = 1; i < prices.length - 1; i++){
            if(postState ^ isIncrease(prices[i], prices[i + 1])){
                localValue.add(prices[i]);
                postState = !postState;
                isLinear = false;
            }
        }
        if(isLinear && postState) return prices[prices.length - 1] - prices[0];
        localValue.add(prices[prices.length - 1]);

        for(int i = 0; i < localValue.size() - 1; i=i+2){
            for(int j = i + 1; j < localValue.size(); j=j+2){
                if(initState){
                    maxProfit = Math.max(localValue.get(j) - localValue.get(i),
                            maxProfit);
                }
                else{
                    maxProfit = Math.max(localValue.get(i) - localValue.get(j),
                            maxProfit);
                }
            }
        }
        return maxProfit;
    }
}