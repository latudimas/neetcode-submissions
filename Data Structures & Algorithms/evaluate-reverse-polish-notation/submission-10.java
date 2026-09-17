class Solution {
    public int evalRPN(String[] tokens) {
        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*")
                && !tokens[i].equals("/")) {
                stack.add(Integer.parseInt(tokens[i]));
            } else {
                int num2 = stack.remove(stack.size() - 1);
                int num1 = stack.remove(stack.size() - 1);

                int total =
                    switch (tokens[i]) {
                        case "+" -> total = num1 + num2;
                        case "-" -> total = num1 - num2;
                        case "*" -> total = num1 * num2;
                        case "/" -> total = num1 / num2;
                        default -> throw new IllegalArgumentException();
                    };

                    // adding calculation result to stack
                    stack.add(total);
            }
        }
        return stack.get(stack.size() - 1);
    }
}
