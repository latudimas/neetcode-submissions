class Solution {
    public int maxProfit(int[] prices) {
        int maxMargin = 0;
        int left = 0;
        int right = 1;
        
        while (right < prices.length) {
            // profit
            if (prices[left] < prices[right]) {
                int margin = prices[right] - prices[left];
                maxMargin = Math.max(maxMargin, margin);
            } else {
                left = right;
            }
            right++;
            
        }
        return maxMargin;
    }
}
