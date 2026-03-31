class Solution {
     public int majorityElement(int[] nums) {
        int threshold = nums.length / 2;
        Map<Integer, Integer> numberToFreq = new HashMap<>();

        System.out.println("threshold: " + threshold);
        for (int num : nums) {
            if (numberToFreq.get(num) == null) {
                numberToFreq.put(num, 1);
            } else {
                numberToFreq.put(num, numberToFreq.get(num) + 1);
            }

        }

        System.out.println("Map: " + numberToFreq);
        for (Map.Entry<Integer, Integer> entity : numberToFreq.entrySet()) {
            if (entity.getValue() > threshold)
                return entity.getKey();

        }

        return -1;

    }
}