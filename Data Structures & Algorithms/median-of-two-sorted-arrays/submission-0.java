class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] smallerArr = nums1.length <= nums2.length ? nums1 : nums2;
        int[] largerArr = nums1.length > nums2.length ? nums1 : nums2;

        int low = 0, high = smallerArr.length;
        int totalLength = smallerArr.length + largerArr.length;


        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (totalLength + 1) / 2 - partitionX;
            int l1 = partitionX == 0 ? Integer.MIN_VALUE : smallerArr[partitionX - 1];
            int r1 = partitionX == smallerArr.length ? Integer.MAX_VALUE : smallerArr[partitionX];

            int l2 = partitionY == 0 ? Integer.MIN_VALUE : largerArr[partitionY - 1];
            int r2 = partitionY == largerArr.length ? Integer.MAX_VALUE : largerArr[partitionY];

            if (l1 <= r2 && l2 <= r1) {
                if (totalLength % 2 == 0) {
                    return ((double) Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return Math.max(l1, l2);
                }
            }

            if (l1 < r2) low = partitionX + 1;
            else high = partitionX - 1;

        }

        return 0;
    }
}
