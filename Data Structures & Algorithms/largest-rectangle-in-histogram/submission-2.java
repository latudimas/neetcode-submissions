class Solution {
    public record Bar(int height, int index) {}

    public int largestRectangleArea(int[] heights) {
        Deque<Bar> stack = new ArrayDeque<>();
        int maxArea = 0;

        // iterate for each position
        for (int i = 0; i < heights.length; i++) {
            int currentHeight = heights[i];
            while (!stack.isEmpty() && heights[i] < stack.peek().height()) {
                Bar bar = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek().index() - 1;
                int area = width * bar.height();
                maxArea = Math.max(maxArea, area); 
            }
            stack.push(new Bar(heights[i], i));
        }

        while (!stack.isEmpty()) {
            Bar bar = stack.pop();
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek().index() - 1;
            int area = width * bar.height();
            maxArea = Math.max(maxArea, area); 
        }

        return maxArea;
    }
}
