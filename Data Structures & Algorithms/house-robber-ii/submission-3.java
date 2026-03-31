class Solution {
  public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] arrWithoutLastHouse = new int[nums.length - 1];
        int[] arrWithoutFirstHouse = new int[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            arrWithoutLastHouse[i] = nums[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            arrWithoutFirstHouse[i] = nums[i + 1];
        }

        return Math.max(getLootValue(arrWithoutLastHouse), getLootValue(arrWithoutFirstHouse));
    }

    private static int getLootValue(int[] nums) {

        int[] loot = new int[nums.length];
        loot[0] = nums[0];
        loot[1] = Math.max(nums[1], nums[0]);

        for (int i = 2; i < nums.length; i++) {
            loot[i] = Math.max(nums[i] + loot[i - 2], loot[i - 1]);
        }

        return loot[nums.length - 1];
    }
}
