class Solution {
    public int trap(int[] height) {
        //Two Pointer solution

        int result = 0;
        // index
        int left = 0;
        int right = height.length - 1;
        
        // value
        int leftMax = height[left];
        int rightMax = height[right];


        while (left<right) {
            int water;

            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax <= rightMax) {
                water = leftMax - height[left];
                left++;
            } else {
                water = rightMax - height[right];
                right--;
            }
            result = result + water;
        }

        return result;
    }
}

