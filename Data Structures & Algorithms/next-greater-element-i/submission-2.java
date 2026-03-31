class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numToIndexMap = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            numToIndexMap.put(nums2[i], i);
        }

        int[] suffixArr = new int[nums2.length];
        Stack<Integer> s = new Stack<>();

        suffixArr[nums2.length - 1] = -1;
        s.push(nums2[nums2.length - 1]);
        for (int i = nums2.length - 2; i >= 0; i--) {
            if (nums2[i] > s.peek()) {
                while (!s.isEmpty() && nums2[i] > s.peek()) {
                    s.pop();
                }
                if (!s.isEmpty()) {
                    suffixArr[i] = s.peek();

                } else {
                    suffixArr[i] = -1;
                }
                s.push(nums2[i]);

            } else {
                suffixArr[i] = s.peek();
                s.push(nums2[i]);
            }
        }

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int index = numToIndexMap.get(nums1[i]);
            ans[i] = suffixArr[index];

        }

        return ans;
    }
}