class Solution {
      public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> index = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (index.isEmpty()) {
                result[i] = 0;
                index.push(i);
            } else {
                while (!index.isEmpty() && temperatures[i] >= temperatures[index.peek()]) {
                    index.pop();
                }
                result[i] = index.isEmpty() ? 0 : index.peek() - i;
                index.push(i);

            }

        }
        return result;
    }
}
