You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
  
  
  codE: 
class Solution {
    public int maxProfit(int k, int[] prices) {
        return maxProfit(k - 1, prices, 0, 0, new Integer[prices.length][2][k]);
    }

    private int maxProfit(int k, int[] prices, int buying, int index, Integer[][][] memo) {
        if (index == prices.length) {
            return 0;
        }
        if (k < 0) {
            return 0;
        }
        if (memo[index][buying][k] != null) {
            return memo[index][buying][k];
        }
        if (buying == 0) {
            int buy = maxProfit(k, prices, buying + 1, index + 1, memo) - prices[index];
            int cooldown = maxProfit(k, prices, buying, index + 1, memo);
            memo[index][buying][k] = Math.max(buy, cooldown);
        } else {
            int sell = maxProfit(k - 1, prices, buying - 1, index + 1, memo) + prices[index];
            int cooldown = maxProfit(k, prices, buying, index + 1, memo);
            memo[index][buying][k] = Math.max(sell, cooldown);
        }
        return memo[index][buying][k];
    }
}
