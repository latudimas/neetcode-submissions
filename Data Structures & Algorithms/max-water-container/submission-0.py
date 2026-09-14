class Solution:
    def maxArea(self, height: List[int]) -> int:
        l = 0
        r = len(height) - 1

        max_area = 0
        while l < r:
            min_h = min(height[l], height[r])
            area = min_h * (r - l)
            max_area = max(max_area, area)

            if height[l] < height[r]:
                l += 1
            elif height[l] > height[r]:
                r -= 1
            else: 
                l += 1

        return max_area