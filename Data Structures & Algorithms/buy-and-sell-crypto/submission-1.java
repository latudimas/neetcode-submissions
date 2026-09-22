class Solution {
    public int maxProfit(int[] prices) {
        int maxMargin = 0;
        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            
            for(int j = i + 1; j < prices.length; j++) {
                if (buy >= prices[j]) {
                    continue;
                } else {
                    // calculate margin
                    int margin = prices[j] - buy;
                    maxMargin = Math.max(maxMargin, margin);
                }
            }
        }
        return maxMargin;
    }
}
