class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int count = 0;
        while(l<r) {
            if(leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                count += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                count += rightMax - height[r];
            }
        }
        return count;
    }
}
