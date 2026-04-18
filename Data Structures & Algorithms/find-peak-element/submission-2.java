class Solution {
   public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int start = 0, end = n - 1, mid;

        while (start <= end) {
            mid = start + (end - start) / 2;


            if (mid > 0 && mid < n - 1) {
                if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid])
                    return mid;
                else if (nums[mid] < nums[mid - 1])
                    end = mid - 1;

                else
                    start = mid + 1;
            } else if (mid == 0) {
                if (nums[mid] > nums[mid + 1])
                    return mid;
                else
                    return mid + 1;

            } else if (mid == n - 1 && nums[mid] > nums[mid - 1]) {
                if (nums[mid] > nums[mid - 1])
                    return n - 1;
                else
                    return mid - 1;
            }

        }

        return -1;
    }
}