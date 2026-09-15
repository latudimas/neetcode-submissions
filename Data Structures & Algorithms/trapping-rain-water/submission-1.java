class Solution {
    public int trap(int[] height) {
        //Naive solution

        int result = 0;

        for (int i = 0; i < height.length; i ++){
            int maxLeft = height[i];
            int maxRight = height[i];
            int left = i-1;
            int right = i+1;

            while ( left >= 0){
                maxLeft = Math.max(height[left], maxLeft);
                left--;
            }

            while (right <= height.length - 1){
                maxRight = Math.max(height[right], maxRight);
                right++;
            }

            int waterLevel = Math.min(maxLeft, maxRight);
            int waterAtIndex = Math.max(0, waterLevel - height[i]); // prevent minus
            result = result + waterAtIndex;

        }

        return result;
    }
}

