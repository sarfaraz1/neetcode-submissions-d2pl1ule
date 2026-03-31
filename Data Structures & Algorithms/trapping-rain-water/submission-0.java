class Solution {
 public int trap(int[] height) {
        int l = 0, r = height.length - 1, lMax = 0, rMax = 0, ans = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                if (lMax > height[l]) {
                    ans += lMax - height[l];
                } else {
                    lMax = height[l];
                }
                l++;
            } else {
                if (rMax > height[r]) {
                    ans += rMax - height[r];
                } else {
                    rMax = height[r];
                }
                r--;
            }
        }

        return ans;
    }
}
