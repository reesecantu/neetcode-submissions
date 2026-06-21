class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] right = new int[len];
        right[0] = 1;
        int[] left = new int[len];
        left[len - 1] = 1;
        int[] result = new int[len];

        for (int i = 1; i < len; i++) {
            right[i] = nums[i - 1] * right[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            left[i] = nums[i + 1] * left[i + 1];
        }
        for (int i = 0; i < len; i++) {
            result[i] = right[i] * left[i];
        }
        return result;
    }
}  
