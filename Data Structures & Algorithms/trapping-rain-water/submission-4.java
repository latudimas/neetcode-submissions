class Solution {
    public int trap(int[] height) {
        //Two Pointer solution

        int result = 0;
        // index or pointer
        int left = 0;
        int right = height.length - 1;
        
        // value
        int leftMax = height[left];
        int rightMax = height[right];


        while (left<right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax <= rightMax) {
                result += leftMax - height[left];
                left++;
            } else {
                result += rightMax - height[right];
                right--;
            }

        }

        return result;
    }
}

