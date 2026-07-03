class Solution {
    public int maxProfit(int[] prices) {
      // two pointers
      // l = buy, r = sell.
      // if r - l is negative, l = r, r = l + 1;
      // if its profitable, update max

      int l = 0, r = 1;
      int maxProfit = 0;

      while (r < prices.length) {
        int profit = prices[r] - prices[l];
        if (profit < 0) {
            l = r;
            r = l + 1;
        } else {
            maxProfit = Math.max(maxProfit, profit);
            r++;
        }
      }
      return maxProfit;
    }
}
