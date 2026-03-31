class Solution {
     int count = 0;
    Map<Integer, Boolean> numberToUtilizedMap = new HashMap<>();

    public int longestConsecutive(int[] nums) {
        // base condition
        if (nums.length == 0) return 0;


        for (int num : nums) {
            numberToUtilizedMap.put(num, Boolean.FALSE);
        }

        int i = 0;
        int count = 1;
        int tempCount = 1;
        int currEle = nums[0];
        numberToUtilizedMap.put(currEle, Boolean.TRUE);
        int nextEle = currEle + 1;
        int prevEle = currEle - 1;

        while (i < nums.length) {
            if (tempCount == 0) {
                currEle = nums[i];
                numberToUtilizedMap.put(currEle, Boolean.TRUE);
                tempCount = 1;
                nextEle = currEle + 1;
                prevEle = currEle - 1;
            }

            if (numberToUtilizedMap.get(nextEle) != null && numberToUtilizedMap.get(nextEle) != Boolean.TRUE) {
                numberToUtilizedMap.put(nextEle, Boolean.TRUE);
                tempCount++;
                count = Math.max(tempCount, count);
                nextEle++;
            } else if (numberToUtilizedMap.get(prevEle) != null && numberToUtilizedMap.get(nextEle) != Boolean.TRUE) {
                numberToUtilizedMap.put(prevEle, Boolean.TRUE);
                tempCount++;
                count = Math.max(tempCount, count);
                prevEle--;

            } else {
                tempCount = 0;
                i++;
                while (i < nums.length && numberToUtilizedMap.get(nums[i]) == Boolean.TRUE)
                    i++;
            }
        }

        return count;
    }
}
