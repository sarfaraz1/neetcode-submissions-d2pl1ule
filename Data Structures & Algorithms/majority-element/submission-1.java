class Solution {
  public int majorityElement(int[] nums) {
        int counter = 0, ele = 0;

        for (int i = 0; i < nums.length; i++) {

            if (counter == 0) {
                ele = nums[i];
                counter = 1;
            } else if (ele == nums[i]) {
                counter++;

            } else
                counter--;

        }
        int counterAns = 0;
        for (int num : nums) {
            if (num == ele)
                counterAns++;

        }

        if (counterAns > nums.length / 2)
            return ele;

        return -1;


    }
}