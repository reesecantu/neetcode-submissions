class Solution {
    public int maxProfit(int[] prices) {
        // in one pass
        // if price goes bellow buy, you can just buy on the new day instead
            // update buy price;
        // if price go above sell
            // update profit
        int max = 0;
        int buy = prices[0];
        int sell = -1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else  {
                sell = prices[i];
                max = Math.max(max, sell - buy);
            }
        } 
        return max;
    }
}
