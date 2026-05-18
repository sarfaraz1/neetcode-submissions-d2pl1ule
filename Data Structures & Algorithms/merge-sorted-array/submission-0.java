class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        for (; k >= 0 && i >= 0 && j >= 0; k--) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }

        if (i == -1 && j != -1)
            while (j >= 0) {
                nums1[k] = nums2[j];
                j--;
                k--;
            }

        if (i != -1 && j == -1)
            while (i >= 0) {
                nums1[k] = nums1[i];
                i--;
                k--;
            }
    }
}