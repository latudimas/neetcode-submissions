class Solution {
    public int trap(int[] height) {
        //Optimized naive solution

        int result = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        // Mapping leftMax
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i ++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Mapping rightMax
        rightMax[height.length - 1] = height[height.length - 1];
        for (int j = height.length - 2; j >= 0; j-- ) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }

        // Calculate water level
        for (int k = 0; k < height.length; k++) {
            int waterLevel = Math.min(leftMax[k], rightMax[k]);
            int waterAtIndex = Math.max(0, waterLevel - height[k]);
            result = result + waterAtIndex;
        }

        return result;
    }
}

