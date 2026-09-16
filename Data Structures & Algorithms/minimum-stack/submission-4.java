class MinStack {

    private record Entry(int value, int min) {}

    List<Entry> stack;

    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        int minVal = stack.isEmpty() 
            ? val 
            : Math.min(stack.get(stack.size() -1).min() , val); // last index minVal vs current val

        stack.add(new Entry(val, minVal));
        
    }
    
    public void pop() {
        stack.remove(stack.size() - 1);
    }
    
    public int top() {
        return stack.get(stack.size() - 1).value(); //last index
    }
    
    public int getMin() {
        return stack.get(stack.size() - 1).min();
    }

}
