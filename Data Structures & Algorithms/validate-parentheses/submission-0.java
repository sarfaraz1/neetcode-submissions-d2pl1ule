class Solution {
    public static boolean isValid(String s) {
        char[] inputArr = s.toCharArray();
        Stack<Character> equation = new Stack<>();
        for (int i = 0; i < inputArr.length; i++) {
            if (!equation.empty()) System.out.println(equation.peek());
            if (!equation.empty() && shouldPop(equation, inputArr[i])) {
                equation.pop();
            } else {
                equation.push(inputArr[i]);
            }
        }
        return equation.empty();
    }

    private static boolean shouldPop(Stack<Character> equation, char c) {
        if (c == ']' && equation.peek() == '[')
            return true;
        else if (c == '}' && equation.peek() == '{')
            return true;

        else if (c == ')' && equation.peek() == '(')
            return true;
        else
            return false;

    }
}


