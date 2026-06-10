class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        for (String operation : operations) {
            if (operation.equals("+")) {
                int a = s.pop();
                int b = s.pop();
                int result = a + b;
                s.push(b);
                s.push(a);
                s.push(result);
            }

            else if (operation.equals("D")) {
                int a = s.pop();
                s.push(a);
                s.push(2 * a);
            }

            else if (operation.equals("C")) {
                s.pop();

            } else {
                int a = Integer.parseInt(operation);
                s.push(a);
            }
        }

        int sum = 0;
        while (!s.isEmpty()) {
            int a = s.pop();
            sum += a;
        }

        return sum;
    }
}