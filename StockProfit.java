class StockProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxValue = prices[prices.length - 1];
        int profit = 0;
        
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] >= maxValue) {
                maxValue = prices[i];
            } else {
                int tempProfit = maxValue - prices[i];
                if (tempProfit > profit) {
                    profit = tempProfit;
                }
            }
        }
        
        return profit;
        
    }
}
