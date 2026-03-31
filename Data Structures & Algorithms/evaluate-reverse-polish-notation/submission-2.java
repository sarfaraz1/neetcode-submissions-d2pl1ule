class Solution {
 public int evalRPN(String[] tokens) {

        if (tokens.length == 1) return Integer.parseInt(tokens[0]);

        Stack<String> numbers = new Stack<>();

        int result = 0;
        for (int i = 0; i < tokens.length; i++) {

            if (isOperator(tokens[i])) {
                int b = Integer.parseInt(numbers.pop());
                int a = Integer.parseInt(numbers.pop());
                result = performOperation(a, b, tokens[i]);
                numbers.push(String.valueOf(result));
            } else {
                numbers.push(tokens[i]);
            }
        }
        return result;
    }

    boolean isOperator(String token) {
        return token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/");
    }

    int performOperation(int a, int b, String operation) {
        if (operation.equals("+"))
            return a + b;
        else if (operation.equals("-"))
            return a - b;
        else if (operation.equals("*"))
            return a * b;
        else
            return a / b;
    }
}
