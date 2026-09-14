class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        min_price = float('inf')

        for p in prices:
            if p < min_price:
                min_price = p
            elif p - min_price > profit:
                profit = p - min_price
            
        return profit
