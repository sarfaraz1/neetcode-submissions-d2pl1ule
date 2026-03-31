class MinStack {

    Stack<Pair> stack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        if (stack.isEmpty())
            stack.push(new Pair(val, val));
        else
            stack.push(new Pair(val, Math.min(val, stack.peek().minVal)));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().minVal;
    }

    class Pair {
        int val;
        int minVal;

        public Pair(int val, int minVal) {
            this.val = val;
            this.minVal = minVal;
        }
    }
}
