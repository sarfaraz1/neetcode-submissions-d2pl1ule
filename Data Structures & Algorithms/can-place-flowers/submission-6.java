class Solution {
 public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;


        if (m == 1 && flowerbed[0] == 0) return true;

        if (m > 2 && flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }

        if (m > 2 && flowerbed[m - 2] == 0 && flowerbed[m - 1] == 0) {
            flowerbed[m - 1] = 1;
            n--;
        }

        for (int i = 0, j = 1; i < m && j < m - 1; i++, j++) {
            if (flowerbed[i] == 0 && flowerbed[j] == 0 && flowerbed[j + 1] == 0) {
                flowerbed[j] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}