class Solution {
    public int evalRPN(String[] tokens) {
        List<Integer> stack = new ArrayList<>();

        for(int i = 0; i < tokens.length; i++) {
            boolean isNumber = tokens[i] != null && tokens[i].matches("-?\\d+");

            if(isNumber){
                stack.add(Integer.parseInt(tokens[i]));
            } else {
                int total = 0;
                int num2 = stack.remove(stack.size() - 1);
                int num1 = stack.remove(stack.size() - 1);
                
                switch (tokens[i]) {
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
