class Solution {
    public int search(int[] nums, int target) {
        int hi = nums.length - 1;
        int lo = 0;

        while (hi >= lo) {
            int i = lo + ((hi - lo) / 2);
            int curr = nums[i];
            if (curr == target) {
                return i;
            } else if (curr < target) {
                lo = i + 1;
            } else {
                hi = i - 1;
            }
        }

        return -1;
    }
}
