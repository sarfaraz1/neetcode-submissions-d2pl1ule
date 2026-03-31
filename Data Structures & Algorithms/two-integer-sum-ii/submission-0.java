class Solution {
         public int[] twoSum(int[] numbers, int target) {
        int j = numbers.length - 1;
        int i = 0;
        while (i < j) {
            if (numbers[i] + numbers[j] > target)
                j--;
            else if (numbers[i] + numbers[j] < target) {
                i++;
            } else
                break;
        }

        i++;
        j++;
        int[] result = new int[]{i,j};
        return result;
    }
}
