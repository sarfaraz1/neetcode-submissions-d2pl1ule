class Solution {
      public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] suffixArr = new int[n];

        suffixArr[n - 1] = arr[n - 1];
        for (int i = n - 2; i > 0; i--) {
            suffixArr[i] = Math.max(arr[i], suffixArr[i + 1]);
        }

        int[] ans = new int[n];

        ans[n - 1] = -1;
        for (int i = 0; i < n - 1; i++) {
            ans[i] = suffixArr[i + 1];

        }
        return ans;
    }
}