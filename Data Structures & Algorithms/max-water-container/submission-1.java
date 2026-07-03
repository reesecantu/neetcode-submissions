class Solution {
    public int maxArea(int[] heights) {
        // left and right pointers
        // move the shortest one inward

        int l = 0;
        int r = heights.length - 1;
        int max = 0;
        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(heights[l], heights[r]));
            if(heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
