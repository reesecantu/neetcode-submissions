class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int buy = prices[0];
        int maxProfit = 0;

        //iterate
        // if curr > buy
            // recalculate max profit
        // else if curr < buy
            // set new buy price

        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i];
            if (curr > buy) {
                maxProfit = Math.max(maxProfit, curr - buy);
            } else {
                buy = curr;
            }
        }

        return maxProfit;
    }
}
