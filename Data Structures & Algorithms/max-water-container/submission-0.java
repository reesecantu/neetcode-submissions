class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            int leftNum = heights[l];
            int rightNum = heights[r];
            max = Math.max(max, Math.min(leftNum, rightNum) * (r - l));
            if (leftNum > rightNum) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }
}
