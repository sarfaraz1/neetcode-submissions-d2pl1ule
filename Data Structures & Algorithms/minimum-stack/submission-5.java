  class MinStack {

        Stack<Long> stack = new Stack<>();
        long minVal = Integer.MAX_VALUE;

        public MinStack() {

        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push((long) val);
                minVal = val;
            } else if (val < minVal) {
                long modifiedMin = 2L * val - minVal;
                stack.push(modifiedMin);
                minVal = val;
            } else
                stack.push(((long) val));
        }

        public void pop() {
            if (stack.peek() < minVal) {
                minVal = 2L * minVal - stack.peek();
            }
            stack.pop();
        }

        public int top() {
            if (stack.peek() < minVal) {
                return (int) minVal;
            }
            return (int) (long) stack.peek();
        }

        public int getMin() {
            return (int) minVal;
        }
    }