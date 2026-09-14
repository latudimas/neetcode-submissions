class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int resArea = 0; //response

        while (left < right) {

            int minHeight = Math.min(heights[left], heights[right]);
            int curArea = minHeight * (right - left);
            resArea = Math.max(resArea, curArea);

            if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            } 
        }

        return resArea;
    }
}
