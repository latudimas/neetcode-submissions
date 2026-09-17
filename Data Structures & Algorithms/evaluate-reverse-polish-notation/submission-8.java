class Solution {
    public int evalRPN(String[] tokens) {
        List<Integer> stack = new ArrayList<>();

        for(int i = 0; i < tokens.length; i++) {
            String currChar = tokens[i];
            boolean isNumber = currChar != null && currChar.matches("-?\\d+");

            if(isNumber){
                stack.add(Integer.parseInt(currChar));
            } else {
                int total = 0;
                int num2 = stack.remove(stack.size() - 1);
                int num1 = stack.remove(stack.size() - 1);
                
                switch (currChar) {
                    case "+" -> total = num1 + num2;
                    case "-" -> total = num1 - num2;
                    case "*" -> total = num1 * num2;
                    case "/" -> total = num1 / num2;
                }
                
                // adding calculation result to stack
                stack.add(total);
            }
        }
        return stack.get(stack.size() - 1);
    }
}
