class Solution {
    public int search(int[] nums, int target) {
        int hi = nums.length;
        int lo = 0;

        while (hi > lo) {
            int i = (hi + lo) / 2;
            int curr = nums[i];
            if (curr == target) {
                return i;
            } else if (curr < target) {
                lo = i + 1;
            } else {
                hi = i;
            }
        }

        return -1;
    }
}
