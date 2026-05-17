class Solution {
  public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {

            boolean destroyed = false;

            // collision happens
            while (!s.isEmpty() && s.peek() > 0 && asteroids[i] < 0) {
                if (s.peek() < Math.abs(asteroids[i])) {
                    s.pop();
                } else if (s.peek() > Math.abs(asteroids[i])) {
                    destroyed = true;
                    break;
                } else if (s.peek() == Math.abs(asteroids[i])) {
                    destroyed = true;
                    s.pop();
                    break;
                }
            }

            if (!destroyed)
                s.push(asteroids[i]);
        }

        while (!s.isEmpty()) {
            ans.add(s.pop());
        }

        ans = ans.reversed();
        int[] finalAns = new int[ans.size()];
        for (int i = 0; i < finalAns.length; i++) {
            finalAns[i] = ans.get(i);
        }
        return finalAns;
    }
}