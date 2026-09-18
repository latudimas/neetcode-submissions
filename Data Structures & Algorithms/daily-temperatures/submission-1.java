class Solution {
    private record Entry(int temp, int idx) {}

    public int[] dailyTemperatures(int[] temperatures) {
        // Improvement SOLUTION
        Deque<Entry> stack = new ArrayDeque<>();
        stack.push(new Entry(temperatures[0], 0));

        int[] output = new int[temperatures.length];

        for (int i = 1; i < temperatures.length; i++){
            // while current temp > stack top
            while (!stack.isEmpty() && stack.peek().temp() < temperatures[i]) {
                output[stack.peek().idx()] = i - stack.peek().idx();
                stack.pop();
            } 
                stack.push(new Entry(temperatures[i], i));
            
        }
        return output;
    }
}
