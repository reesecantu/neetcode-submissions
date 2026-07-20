class Solution {
    public int maxSubArray(int[] nums) {
        // traverse, if sum so far is negative, drop it
        int max = nums[0];
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currSum < 0) {
                currSum = nums[i];
            } else {
                currSum += nums[i];
            }
            max = Math.max(max, currSum);
        }
        return max;
    }
}
