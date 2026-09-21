class Solution {
    public record Bar(int height, int index) {}

    public int largestRectangleArea(int[] heights) {
        /*
         *   if I choose this bar's height,
         *   how far can I extend left and right
         *   while every bar is at least this tall?
         */

        // create stack
        // for each bar i
        //     while stack not empty
        //     AND current height < height at stack top
        //         pop previous bar
        //         calculate its rectangle
        //     push current bar

        Deque<Bar> stack = new ArrayDeque<>();
        int maxArea = 0;

        // iterate for each position
        for (int i = 0; i < heights.length; i++) {
            int currentHeight = heights[i];
            while (!stack.isEmpty() && heights[i] < stack.peek().height()) {
                Bar poppedBar = stack.pop();
                int height = poppedBar.height();
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek().index() - 1;
                }
                // calcuate the area
                int area = width * height;
                // compare area with maxArea using Math.max
                maxArea = Math.max(maxArea, area); 
            }
            stack.push(new Bar(heights[i], i));
        }

        while (!stack.isEmpty()) {
            Bar poppedBar = stack.pop();
            int height = poppedBar.height();
            int width;
            if (stack.isEmpty()) {
                width = heights.length;
            } else {
                width = heights.length - stack.peek().index() - 1;
            }
            int area = width * height;
                // compare area with maxArea using Math.max
            maxArea = Math.max(maxArea, area); 
        }

        return maxArea;
    }
}
