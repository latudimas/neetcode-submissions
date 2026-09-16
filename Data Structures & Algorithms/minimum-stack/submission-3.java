class MinStack {
    // Stack -> array like data structure but you only modify data in the edge (last element)
    // push -> data insertion on the edge
    // pop -> data extraction from the edge
    // top -> value on the edge
    // getMin -> minimum element in the stack

    // List -> push pop top (easy)
    // getMin -> question: if the current min value id "pop", how to promote next candidate from current data in the list

    List<Integer> myStack;
    List<Integer> minStack;

    public MinStack() {
        myStack = new ArrayList<>();
        minStack = new ArrayList<>();
    }
    
    public void push(int val) {

        if (myStack.size() == 0 ) {
            myStack.add(val);
            minStack.add(val);
        } else {
            myStack.add(val);
        

            // System.out.println("CurrIdx: " + currIdx());
            int currMin = Math.min(minStack.get(currMinIdx()), val);
            minStack.add(currMin);
        }
        
    }
    
    public void pop() {
        myStack.remove(currStackIdx()); // last index
        minStack.remove(currMinIdx());

    }
    
    public int top() {
        return myStack.get(currStackIdx()); //last index
    }
    
    public int getMin() {
        return minStack.get(currMinIdx());
    }

    private int currStackIdx() {
        return myStack.size() == 0 ? 0: myStack.size() - 1;
    }

    private int currMinIdx() {
        return minStack.size() == 0 ? 0: minStack.size() - 1;
    }
}
