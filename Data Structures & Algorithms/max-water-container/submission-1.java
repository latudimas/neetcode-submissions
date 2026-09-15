class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int resArea = 0; //response

        if (heights.length == 0) {
            return 0;
        }

        while (left < right) {

            int minHeight = Math.min(heights[left], heights[right]);
            int curArea = minHeight * (right - left);
            resArea = Math.max(resArea, curArea);

            if (left > right) {
                right--;
            } else if (left < right) {
                left++;
            } else {
                left++;
                right--;
            }
        }

        return resArea;
    }
}
