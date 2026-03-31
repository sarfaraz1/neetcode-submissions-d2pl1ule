class Solution {
   public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target, "first");
        int last = binarySearch(nums, target, "last");

        int[] result = new int[2];
        result[0] = first;
        result[1] = last;
        return result;

    }


    int binarySearch(int[] nums, int target, String occurrenceType) {
        int ans = -1;
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                ans = mid;
                if (occurrenceType.equals("first")) {
                    end = mid - 1;

                } else
                    start = mid + 1;
            } else if (nums[mid] > target) {

                end = mid - 1;
            } else
                start = mid + 1;
        }

        return ans;
    }
}